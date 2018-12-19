package www.pradhan.com.saha_sample.util;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import www.pradhan.com.saha_sample.db.SahakaritaContract;

public class InsertFakeData {

    public static void insertFakeData(SQLiteDatabase db) {
        if (db == null) {
            return;
        }
        //create a list of fake guests
        List<ContentValues> list = new ArrayList<>();

        ContentValues cv = new ContentValues();
        cv.put(SahakaritaContract.AgentEntry.COLUMN_AGENTNAME, "Ritvik");
        cv.put(SahakaritaContract.AgentEntry.COLUMN_COLLECTIONAMT, 1200);
        cv.put(SahakaritaContract.AgentEntry.COLUMN_AGENTID, 12);
        list.add(cv);

        cv = new ContentValues();
        cv.put(SahakaritaContract.AgentEntry.COLUMN_AGENTNAME, "Praveen");
        cv.put(SahakaritaContract.AgentEntry.COLUMN_COLLECTIONAMT, 327847);
        cv.put(SahakaritaContract.AgentEntry.COLUMN_AGENTID, 54);
        list.add(cv);

        cv = new ContentValues();
        cv.put(SahakaritaContract.AgentEntry.COLUMN_AGENTNAME, "Amrit");
        cv.put(SahakaritaContract.AgentEntry.COLUMN_COLLECTIONAMT, 52050);
        cv.put(SahakaritaContract.AgentEntry.COLUMN_AGENTID, 9);
        list.add(cv);

        cv = new ContentValues();
        cv.put(SahakaritaContract.AgentEntry.COLUMN_AGENTNAME, "Kishor");
        cv.put(SahakaritaContract.AgentEntry.COLUMN_COLLECTIONAMT, 52060);
        cv.put(SahakaritaContract.AgentEntry.COLUMN_AGENTID, 82);
        list.add(cv);

        cv = new ContentValues();
        cv.put(SahakaritaContract.AgentEntry.COLUMN_AGENTNAME, "Leena");
        cv.put(SahakaritaContract.AgentEntry.COLUMN_COLLECTIONAMT, 75000);
        cv.put(SahakaritaContract.AgentEntry.COLUMN_AGENTID, 32);
        list.add(cv);

        //insert all guests in one transaction
        try {
            db.beginTransaction();
            //clear the table first
            db.delete(SahakaritaContract.AgentEntry.TABLE_NAME, null, null);
            //go through the list and add one by one
            for (ContentValues c : list) {
                db.insert(SahakaritaContract.AgentEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            //too bad :(
            //TODO A3 : Append error to log file
        } finally {
            db.endTransaction();
        }

    }


}
