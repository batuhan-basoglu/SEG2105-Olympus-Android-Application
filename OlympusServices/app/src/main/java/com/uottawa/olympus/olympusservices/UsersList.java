package com.uottawa.olympus.olympusservices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.Iterator;
import java.util.List;

/**
 * screen for user list that the admin can access
 * and manage all users in the program. Userlist is generated through
 * the database using DBHelper class.
 *
 */

public class UsersList extends AppCompatActivity {

    /**
     * on Creation of this class the app loads up the xml page for
     * activity_user_list and generates a gridview using the database
     * for all the users in the app.
     *
     * @param savedInstanceState bundle to transfer data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        DBHelper dbHelper = new DBHelper(this);
        List<String[]> users = dbHelper.getAllUsers();
        String[] usernames = new String[(users.size()+1)*2];
        usernames[0] = "Username";
        usernames[1] = "User Type";
        Iterator iter = users.iterator();
        for (int i=0; i<users.size();i++){
            String[] current = (String[])iter.next();
            usernames[(i+1)*2] = current[0];
            usernames[(i+1)*2+1] = current[3];
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item_1_customized, usernames);
        GridView gridView = findViewById(R.id.Users);
        gridView.setAdapter(adapter);
    }
}
