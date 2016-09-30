# CustomListView_jadi
1. make cutom lay out and give the unique id
2. make class extend array adapter for your custom adapter
3. add constructor to your adapter consider how wil you instace your adapter (push and pull parameter)
in this case >
            public CustomAdapterClass(Context context, String[] names, String[] factory, String[] year, int[] imgs) {
                    super(context, R.layout.customlist, names);

                    //
                    this.c = context;
                    this.names =names;
                    this.factory = factory;
                    this.year = year;
                    this.imgs = imgs;
                }
4. makae inner property in your custom adapter to handle data
in this case >
//
             int[] imgs = {};
                String[] factory = {};
                String[] names = {};
                String[] year = {};
                Context c;
                LayoutInflater inflater;
//
note : lay out inflater use for handing instance looping creating layout each data in list view

5. wiring your constructor to your property....
in this case >
//
             this.c = context;
             this.names =names;
             this.factory = factory;
             this.year = year;
             this.imgs = imgs;
//           
6. make your own getview method (override)
in this case >
//
              @Override
                  public View getView(int position, View convertView, ViewGroup parent) {
                      if (convertView == null){
                          inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                          convertView = inflater.inflate(R.layout.customlist,null);
                      }
//
get view method is used for request a view every data in your custom list view

7. make view holder for your view... its like wiring
in this case >
//
             public class ViewHolder{
                  TextView tvName;
                  TextView tvFactory;
                  TextView tvYear;
                  ImageView ivList;
              }
//            
8. make view holder object
in this case >
            // instance view holder
            final ViewHolder holder = new ViewHolder();
            
9. insance your view this also part of wiring
inthis case >
//
            // initialize view
            holder.tvName = (TextView) convertView.findViewById(R.id.txt_nama);
            holder.tvFactory = (TextView) convertView.findViewById(R.id.txt_pabrik);
            holder.tvYear = (TextView)convertView.findViewById(R.id.txt_tahun);
            holder.ivList = (ImageView)convertView.findViewById(R.id.iv_list_img);

10. asign data to your view final part of wiring
in this case >
            // assign data
            holder.ivList.setImageResource(imgs[position]);
            holder.tvName.setText(names[position]);
            holder.tvFactory.setText(factory[position]);
            holder.tvYear.setText(year[position]);
            
11. fina is return convert view to your main class
in this case >
            return convertView;

12. ok back to your activity.
13 make object null listview
14 make object custom adapter as you created, remember the parameter that you use in yourconstructor.
15 the then wiring your listview to your adapter.
