package com.example.NEMACOLLECT;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.nfc.Tag;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//import static com.example.NEMACOLLECT.DatabaseTable.DatabaseOpenHelper.FTS_VIRTUAL_TABLE;

public class DatabaseTable {
    private static final String FTS_VIRTUAL_TABLE = "FTS";
    private final DatabaseOpenHelper databaseOpenHelper;

    public Cursor getWordMatches(String query, String[] columns){
        String COL_NAME = new String();
        String selection = COL_NAME + "MATCH ?";
        String[] selectionArgs = new String[] {query+"*"};

        return query(selection, selectionArgs, columns);
    }

    private Cursor query(String selection, String[] selectionArgs, String[] columns){
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(FTS_VIRTUAL_TABLE);

        Cursor cursor = builder.query(databaseOpenHelper.getReadableDatabase(),columns, selection,selectionArgs, null,null,null);

        if (cursor == null){
            return null;
        }else if (!cursor.moveToFirst()){
            cursor.close();
            return null;
        }
        return cursor;
    }

    public DatabaseTable(Context context) {
        databaseOpenHelper = new DatabaseOpenHelper(context);
    }

    static class DatabaseOpenHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "SEARCHES.db";
        private static final int DATABASE_VERSION = 1;
        private static final String TAG ="DocumentsDatabase";
        private final Context helperContext;
        private SQLiteDatabase mDatabase;

        private static final String COL_NAME = "name";
        private static final String COL_ID = "ID" ;
        private static final String FTS_VIRTUAL_TABLE = "FTS";
        private static final String FTS_TABLE_CREATE = String.format("CREATE VIRTUAL TABLE%sUSING fts3 (%sDOCUMENT%s)", FTS_VIRTUAL_TABLE, COL_NAME, COL_ID);
        //private Object Tag;

        DatabaseOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            helperContext = context;
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            mDatabase = db;
            mDatabase.execSQL(FTS_TABLE_CREATE);
            loadData();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w((String) TAG, "Upgrading database from version" + oldVersion + "to" + newVersion + ", which will destroy all old data");
            db.execSQL(String.format("DROP TABLE IF EXISTS%s", FTS_VIRTUAL_TABLE));
            onCreate(db);
        }

        private void loadData(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        loadDocuments();
                    } catch (IOException e){
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }

        private void loadDocuments() throws IOException{
            final Resources resources = helperContext.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.definitions);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            try {
                String line;
                while ((line = reader.readLine()) != null){
                    String[] strings = TextUtils.split(line, "-");
                    if (strings.length < 2) continue;
                    long id = addName(strings[0].trim(), strings[1].trim());
                    if (id < 0){
                        Log.e((String) TAG, "unable to add document:" + strings[0].trim());
                    }
                }
            }finally {
                reader.close();
            }
        }

        public long addName(String name, String ID){
            ContentValues initialValues = new ContentValues();
            initialValues.put(COL_NAME,name);
            initialValues.put(COL_ID,ID);

            return mDatabase.insert(FTS_VIRTUAL_TABLE,null, initialValues);
        }
    }
}
