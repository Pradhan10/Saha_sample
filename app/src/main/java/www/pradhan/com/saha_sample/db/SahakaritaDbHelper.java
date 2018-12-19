package www.pradhan.com.saha_sample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SahakaritaDbHelper extends SQLiteOpenHelper {

    /*DB name*/
    private static final String DATABASE_NAME = "sahakarita.db";
    /*version*/
    private static final int DATABASE_VERSION = 1;

    public SahakaritaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*
         * This String will contain a simple SQL statement that will create a table that will
         * cache our collection agent data.
         */
        final String SQL_CREATE_WEATHER_TABLE =

                "CREATE TABLE " + SahakaritaContract.AgentEntry.TABLE_NAME + " (" +

                        /*
                         * AgentEntry did not explicitly declare a column called "_ID". However,
                         * AgentEntry implements the interface, "BaseColumns", which does have a field
                         * named "_ID". We use that here to designate our table's primary key.
                         */
                        SahakaritaContract.AgentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                        SahakaritaContract.AgentEntry.COLUMN_DATE + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +

                        SahakaritaContract.AgentEntry.COLUMN_AGENTID + " INTEGER NOT NULL, " +

                        SahakaritaContract.AgentEntry.COLUMN_AGENTNAME + " TEXT NOT NULL, " +

                        SahakaritaContract.AgentEntry.COLUMN_COLLECTIONAMT + " REAL NOT NULL" + ");";

        /*
         * After we've spelled out our SQLite table creation statement above, we actually execute
         * that SQL with the execSQL method of our SQLite database object.
         */
        sqLiteDatabase.execSQL(SQL_CREATE_WEATHER_TABLE);
    }

    /*Used to change schema in future. Write query to drop existing schema and create new one without data loss*/
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        /*TODO A2 : Future release and schema changes*/
    }
}
