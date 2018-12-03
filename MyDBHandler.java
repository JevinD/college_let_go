package net.jevindement.collegeletgo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentDB.db";
    public static final String TABLE_NAME = "Student";
    public static final String COLUMN_ID = "PostID";
    public static final String COLUMN_NAME = "StudentName";
    public static final String COLUMN_NAME2 = "PostTitle";
    public static final String COLUMN_NAME3 = "Description";
    public static final String COLUMN_NAME4 = "Active";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_ID +
                " TEXT PRIMARY KEY, " + COLUMN_NAME + " TEXT, " + COLUMN_NAME2 +
                " TEXT, " + COLUMN_NAME3 + " TEXT, " + COLUMN_NAME4 + " BOOLEAN)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String loadHandler() {
        String result = "";
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }
    public void addHandler(Student student, String postTitle, String postDescription) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, student.getStudentName() + student.numPosts);
        values.put(COLUMN_NAME, student.getStudentName());
        values.put(COLUMN_NAME2, postTitle);
        values.put(COLUMN_NAME3, postDescription);
        values.put(COLUMN_NAME4, true);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
        student.post();
    }

    public Student findHandler(String studentID, String password) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " = '" + studentID +
                "' AND " + COLUMN_NAME3 + " = '" + password + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Student student = new Student();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            student.setEmail(Integer.parseInt(cursor.getString(0)));
            student.setStudentName(cursor.getString(1), cursor.getString(2));
            cursor.close();
        } else {
            student = null;
        }
        db.close();
        return student;
    }

    /*
    public boolean deleteHandler() {
        boolean result = false;
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = '" + String.valueOf(email) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Student student = new Student();
        if (cursor.moveToFirst()) {
            student.setEmail(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_NAME, COLUMN_ID + "=?",
                    new String[] {
                String.valueOf(student.getEmail())
            });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }*/

    /*public boolean updateHandler(String postID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, email);
        args.put(COLUMN_NAME, first);
        args.put(COLUMN_NAME2, last);
        args.put(COLUMN_NAME3, password);
        return db.update(TABLE_NAME, args, COLUMN_ID + " = " + email, null) > 0;
    }*/
}
