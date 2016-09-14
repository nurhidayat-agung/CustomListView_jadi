package selowdev.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] names = {"toyota", "xenia", "kijang", "vario", "apv"};
    String[] factory = {"honda", "dahatsu", "yamaha", "piago", "sedan"};
    String[] year = {"1992", "1998", "2000","1768", "1968"};
    int[] images = {R.drawable.mobil,R.drawable.mobil,R.drawable.mobil,R.drawable.mobil,R.drawable.mobil};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // wiring listview
        lv = (ListView) findViewById(R.id.listView);

        // adapter
        CustomAdapterClass adapterClass = new CustomAdapterClass(this, names,factory,year, images);

        // wiring adapter and listview
        lv.setAdapter(adapterClass);

        // set onclick listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long dur) {
                Toast.makeText(getApplicationContext(), names[pos], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
