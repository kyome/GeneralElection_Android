package lets.vote.generalelection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static lets.vote.generalelection.CandidateContract.SQL_CREATE_ENTRIES;
import static lets.vote.generalelection.CandidateContract.SQL_DELETE_ENTRIES;

public class CandidateDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME = "CandidateReader.db";

    public CandidateDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(newVersion==DATABASE_VERSION){
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }
    }
}
