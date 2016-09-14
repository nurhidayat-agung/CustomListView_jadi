package selowdev.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by kazt on 15/09/16.
 */
public class CustomAdapterClass extends ArrayAdapter<String> {

    // inisialisation
    int[] imgs = {};
    String[] factory = {};
    String[] names = {};
    String[] year = {};
    Context c;
    LayoutInflater inflater;



    public CustomAdapterClass(Context context, String[] names, String[] factory, String[] year, int[] imgs) {
        super(context, R.layout.customlist, names);

        //
        this.c = context;
        this.names =names;
        this.factory = factory;
        this.year = year;
        this.imgs = imgs;
    }

    //inner class holder vieweach row
    public class ViewHolder{
        TextView tvName;
        TextView tvFactory;
        TextView tvYear;
        ImageView ivList;


    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.customlist,null);
        }

        // instance view holder
        final ViewHolder holder = new ViewHolder();

        // initialize view
        holder.tvName = (TextView) convertView.findViewById(R.id.txt_nama);
        holder.tvFactory = (TextView) convertView.findViewById(R.id.txt_pabrik);
        holder.tvYear = (TextView)convertView.findViewById(R.id.txt_tahun);
        holder.ivList = (ImageView)convertView.findViewById(R.id.iv_list_img);


        // assign data
        holder.ivList.setImageResource(imgs[position]);
        holder.tvName.setText(names[position]);
        holder.tvFactory.setText(factory[position]);
        holder.tvYear.setText(year[position]);


        return convertView;
    }
}
