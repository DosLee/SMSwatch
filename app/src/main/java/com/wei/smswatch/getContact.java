package com.wei.smswatch;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;


/**
 * 联系人
 */
public class getContact{
    private static String TAG = "getContact";
    public static void getAllContacts(Context context) throws Exception {
        ContentResolver cr = context.getContentResolver();
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {

            String ContactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + ContactId, null, null);
            while (phone.moveToNext()) {
                String PhoneNumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                String PhoneName = phone.getString(phone.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                PhoneNumber = PhoneNumber.replace("-", "");
                PhoneNumber = PhoneNumber.replace(" ", "");
                String d = ContactId + "|" + PhoneName + "|" + PhoneNumber;
                Log.d(TAG, "getAllContacts: 联系人: " + d);
            }
        }
    }
}