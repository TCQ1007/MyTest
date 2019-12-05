package com.example.myapplication000;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private double mViewWidth;
    private double mViewHeight;
    final PopupWindow bottomWindow = null;
    ListView listview;
    private int camFlag = 0;
    private View mView = null ;
    TextView article;
    Fragment exFragment;
    LinearLayout readpage;
    private PopupWindow popupholoWindow;
    String article1 = "1872\n" +
            "FAIRY TALES OF HANS CHRISTIAN ANDERSEN\n" +
            "A CHEERFUL TEMPER\n" +
            "by Hans Christian Andersen\n" +
            " \n" +
            "FROM my father I received the best inheritance, namely a \"good temper.\" \"And who was my father?\" That has nothing to do with the good temper; but I will say he was lively, good-looking round, and fat; he was both in appearance and character a complete contradiction to his profession. \"And pray what was his profession and his standing in respectable society?\" Well, perhaps, if in the beginning of a book these were written and printed, many, when they read it, would lay the book down and say, \"It seems to me a very miserable title, I don't like things of this sort.\" And yet my father was not a skin-dresser nor an executioner; on the contrary, his employment placed him at the head of the grandest people of the town, and it was his place by right. He had to precede the bishop, and even the princes of the blood; he always went first,- he was a hearse driver!\n" +
            "There, now, the truth is out. And I will own, that when people saw my father perched up in front of the omnibus of death, dressed in his long, wide, black cloak, and his black-edged, three-cornered hat on his head, and then glanced at his round, jocund face, round as the sun, they could not think much of sorrow or the grave. That face said, \"It is nothing, it will all end better than people think.\" So I have inherited from him, not only my good temper, but a habit of going often to the churchyard, which is good, when done in a proper humor; and then also I take in the Intelligencer, just as he used to do.\n" +
            "I am not very young, I have neither wife nor children, nor a library, but, as I said, I read the Intelligencer, which is enough for me; it is to me a delightful paper, and so it was to my father. It is of great use, for it contains all that a man requires to know; the names of the preachers at the church, and the new books which are published; where houses, servants, clothes, and provisions may be obtained. And then what a number of subscriptions to charities, and what innocent verses! Persons seeking interviews and engagements, all so plainly and naturally stated. Certainly, a man who takes in the Intelligencer may live merrily and be buried contentedly, and by the end of his life will have such a capital stock of paper that he can lie on a soft bed of it, unless he prefers wood shavings for his resting-place. The newspaper and the churchyard were always exciting objects to me. My walks to the latter were like bathing-places to my good humor. Every one can read the newspaper for himself, but come with me to the churchyard while the sun shines and the trees are green, and let us wander among the graves. Each of them is like a closed book, with the back uppermost, on which we can read the title of what the book contains, but nothing more. I had a great deal of information from my father, and I have noticed a great deal myself. I keep it in my diary, in which I write for my own use and pleasure a history of all who lie here, and a few more beside.\n" +
            "\n" +
            "Now we are in the churchyard. Here, behind the white iron railings, once a rose-tree grew; it is gone now, but a little bit of evergreen, from a neighboring grave, stretches out its green tendrils,and makes some appearance; there rests a very unhappy man, and yet while he lived he might be said to occupy a very good position. He had enough to live upon, and something to spare; but owing to his refined tastes the least thing in the world annoyed him. If he went to a theatre of an evening, instead of enjoying himself he would be quite annoyed if the machinist had put too strong a light into one side of the moon, or if the representations of the sky hung over the scenes when they ought to have hung behind them; or if a palm-tree was introduced into a scene representing the Zoological Gardens of Berlin, or a cactus in a view of Tyrol, or a beech-tree in the north of Norway. As if these things were of any consequence! Why did he not leave them alone? Who would trouble themselves about such trifles? especially at a comedy, where every one is expected to be amused. Then sometimes the public applauded too much, or too little, to please him.\n" +
            "\"They are like wet wood,\" he would say, looking round to see what sort of people were present, \"this evening; nothing fires them.\" Then he would vex and fret himself because they did not laugh at the right time, or because they laughed in the wrong places; and so he fretted and worried himself till at last the unhappy man fretted himself into the grave.\n" +
            "Here rests a happy man, that is to say, a man of high birth and position, which was very lucky for him, otherwise he would have been scarcely worth notice. It is beautiful to observe how wisely nature orders these things. He walked about in a coat embroidered all over,and in the drawing-rooms of society looked just like one of those rich pearl-embroidered bell-pulls, which are only made for show; and behind them always hangs a good thick cord for use. This man also had a stout, useful substitute behind him, who did duty for him, and performed all his dirty work. And there are still, even now, these serviceable cords behind other embroidered bell-ropes. It is all so wisely arranged, that a man may well be in a good humor.\n" +
            "Here rests,- ah, it makes one feel mournful to think of him!-but here rests a man who, during sixty-seven years, was never remembered to have said a good thing; he lived only in the hope of having a good idea. At last he felt convinced, in his own mind, that he really had one, and was so delighted that he positively died of joy at the thought of having at last caught an idea. Nobody got anything by it; indeed, no one even heard what the good thing was. Now I can imagine that this same idea may prevent him from resting quietly in his grave; for suppose that to produce a good effect, it is necessary to bring out his new idea at breakfast, and that he can only make his appearance on earth at midnight, as ghosts are believed generally to do; why then this good idea would not suit the hour, and the man would have to carry it down again with him into the grave- that must be a troubled grave.\n" +
            "The woman who lies here was so remarkably stingy, that during her life she would get up in the night and mew, that her neighbors might think she kept a cat. What a miser she was!\n" +
            "Here rests a young lady, of a good family, who would always make her voice heard in society, and when she sang \"Mi manca la voce,\"*\n" +
            "it was the only true thing she ever said in her life.\n" +
            "* \"I want a voice,\" or, \"I have no voice.\"\n" +
            "Here lies a maiden of another description. She was engaged to be married,- but, her story is one of every-day life; we will leave her to rest in the grave.\n" +
            "Here rests a widow, who, with music in her tongue, carried gall in her heart. She used to go round among the families near, and search out their faults, upon which she preyed with all the envy and malice of her nature. This is a family grave. The members of this family held so firmly together in their opinions, that they would believe in no other. If the newspapers, or even the whole world, said of a certain subject, \"It is so-and-so;\" and a little schoolboy declared he had learned quite differently, they would take his assertion as the only true one, because he belonged to the family. And it is well known that if the yard-cock belonging to this family happened to crow at midnight, they would declare it was morning, although the watchman and all the clocks in the town were proclaiming the hour of twelve at night.\n" +
            "The great poet Goethe concludes his Faust with the words, \"may be continued;\" so might our wanderings in the churchyard be continued.\n" +
            "I come here often, and if any of my friends, or those who are not my friends, are too much for me, I go out and choose a plot of ground in which to bury him or her. Then I bury them, as it were; there they lie, dead and powerless, till they come back new and better characters. Their lives and their deeds, looked at after my own fashion, I write down in my diary, as every one ought to do. Then, if any of our friends act absurdly, no one need to be vexed about it. Let them bury the offenders out of sight, and keep their good temper. They can also read the Intelligencer, which is a paper written by the people, with their hands guided. When the time comes for the history of my life, to be bound by the grave, then they will write upon it as my epitaph- \n" +
            "\"The man with a cheerful temper.\"\n" +
            "\n" +
            "And this is my story.\n" +
            " \n" +
            "THE END\n" +
            "\n" +
            "IndexNext\n" +
            "\n" +
            "Written By Anderson\n";
    private OnUserNeedSettingListener mOnUserNeedSettingListener;

    public interface OnUserNeedSettingListener {
        void onUserNeedSetting();
    }
    //返回当前的接口对象
    public OnUserNeedSettingListener getOnUserNeedSettingListener() {
        return mOnUserNeedSettingListener;
    }
    //给当前接口对象初始化，下面的set方法的初始化是运用接口回调，初始化一个重载了函数的匿名类
    public void setOnUserNeedSettingListener(OnUserNeedSettingListener onUserNeedSettingListener) {
        mOnUserNeedSettingListener = onUserNeedSettingListener;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mView = (View) findViewById(R.id.articlebackground);
        mView.setOnTouchListener(CenterOnTouchListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommonUtil.setFullScreen(MainActivity.this);
        setContentView(R.layout.activity_main);

        exFragment = (Fragment)getFragmentManager().findFragmentById(R.id.fragment_readmain);
        article =(TextView) exFragment.getView().findViewById(R.id.article);
        readpage =(LinearLayout)exFragment.getView().findViewById(R.id.readpage);

        SharedPreferences pref = getSharedPreferences("readset",MODE_PRIVATE);
        int abgc = pref.getInt("abgc",R.color.ArticleBGColor);
        int ac = pref.getInt("ac",R.color.ArticleColor);
        Toast.makeText(MainActivity.this,abgc+"\n"+ac,Toast.LENGTH_SHORT).show();
        article.setTextColor(getResources().getColor(ac));
        readpage.setBackgroundColor(getResources().getColor(abgc));

        setServicePolicy();

        save("color:"+Integer.toHexString(article.getCurrentTextColor()),"data");
        Log.d("article",article.getTextColors().toString());

        setOnUserNeedSettingListener(new  OnUserNeedSettingListener() {
            @Override
            public void onUserNeedSetting() {
                //加载popup时同时加载fragment
                FragmentManager fragmentManager =getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                HeaderFragment HF = new HeaderFragment();
                transaction.replace(R.id.header_read,HF);
                transaction.commit();
                CommonUtil.cancelFullScreen(MainActivity.this);
                myPopupWindow();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("msg",data.toString());
        if (resultCode == Activity.RESULT_OK) {//是否选择，没选择就不会继续
            Log.d("msg","onActivityResult1");
            Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
//            Log.d("msg","onActivityResult2"+uri.toString());
//            String[] proj = {MediaStore.Images.Media.DATA};
//            Log.d("msg","onActivityResult3");
//            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
//            Log.d("msg","onActivityResult4");
//            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            Log.d("msg","onActivityResult5");
//            actualimagecursor.moveToFirst();
//            Log.d("msg","onActivityResult6");
//            String img_path = actualimagecursor.getString(actual_image_column_index);
//            Log.d("msg","onActivityResult6"+img_path);
            String p = getRealPathFromURI(uri);
            Log.d("aaa","路径"+p);
            Toast.makeText(MainActivity.this, "路径"+p, Toast.LENGTH_LONG).show();
            //save(img_path,"test");
            //File file = new File(img_path);
            //readFile(img_path);

        }
        Toast.makeText(MainActivity.this, "onActivityResult!", Toast.LENGTH_SHORT).show();
    }
    public String getRealPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if(cursor.moveToFirst()){;
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }
    public static void readFile(String pathname) {
         // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271

        try {
            FileReader reader = new FileReader(pathname);
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                Log.d("readArticle",line);
                //System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(MainActivity.this, article.getTextColors().toString(), Toast.LENGTH_SHORT).show();
    }

    public void myPopupWindow(){
        //popupWindow 操作代码部分
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vPopupWindow = inflater.inflate(R.layout.popupwindow_readset, null, false);//引入弹窗布局
        final PopupWindow popupWindow = new PopupWindow(vPopupWindow, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        //设置背景透明
        addBackground(popupWindow);
        //设置进出动画
        popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        //引入依附的布局
        View parentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.fragment_readmain, null);
        //相对于父控件的位置（例如正中央Gravity.CENTER，下方Gravity.BOTTOM等），可以设置偏移或无偏移
        popupWindow.showAtLocation(parentView, Gravity.BOTTOM, 0, 0);
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        popupWindow.setTouchable(true);
        //popupWindow 操作代码部分 end
        //获取popup中要绑定事件的控件id
        Button btnfont1 = (Button)vPopupWindow.findViewById(R.id.font1);
        Button btnfont2 = (Button)vPopupWindow.findViewById(R.id.font2);
        Button btc1 = (Button)vPopupWindow.findViewById(R.id.color1);
        Button btc2 = (Button)vPopupWindow.findViewById(R.id.color2);
        Button btc3 = (Button)vPopupWindow.findViewById(R.id.color3);
        Button btc4 = (Button)vPopupWindow.findViewById(R.id.color4);
        Button btc5 = (Button)vPopupWindow.findViewById(R.id.color5);
        ImageButton btnmulu = (ImageButton)vPopupWindow.findViewById(R.id.mulu);

        ImageButton btnfontset = (ImageButton)vPopupWindow.findViewById(R.id.font_set);
        ImageButton btndanciben = (ImageButton)vPopupWindow.findViewById(R.id.danciben);

        btnmulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
                mDrawerLayout.openDrawer(GravityCompat.START);
                popupWindow.dismiss();
            }
        });
        //自定义监听
        View.OnClickListener ReadSetOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("readset",MODE_PRIVATE).edit();
                switch (view.getId()){
                    //两个字体大小设置按钮
                    case R.id.font1:
                        article.setTextSize(TypedValue.COMPLEX_UNIT_PX,(int)article.getTextSize()+1);
                        break;
                    case R.id.font2:
                        article.setTextSize(TypedValue.COMPLEX_UNIT_PX,(int)article.getTextSize()-1);
                        break;
                    //五个颜色设置按钮
                    case R.id.color1:
                        readpage.setBackgroundColor(getResources().getColor(R.color.ArticleBGColor1));
                        article.setTextColor(getResources().getColor(R.color.ArticleColor1));
                        editor.putInt("ac",R.color.ArticleColor1);
                        editor.putInt("abgc",R.color.ArticleBGColor1);
                        editor.apply();
                        break;
                    case R.id.color2:
                        article.setTextColor(getResources().getColor(R.color.ArticleColor2));
                        readpage.setBackgroundColor(getResources().getColor(R.color.ArticleBGColor2));
                        editor.putInt("ac",R.color.ArticleColor2);
                        editor.putInt("abgc",R.color.ArticleBGColor2);
                        editor.apply();
                        Log.d("article",R.color.ArticleColor2+"|"+R.color.ArticleBGColor2+"");
                        break;
                    case R.id.color3:
                        readpage.setBackgroundColor(getResources().getColor(R.color.ArticleBGColor3));
                        article.setTextColor(getResources().getColor(R.color.ArticleColor3));
                        editor.putInt("ac",R.color.ArticleColor3);
                        editor.putInt("abgc",R.color.ArticleBGColor3);
                        editor.apply();
                        Log.d("article",article.getTextColors().toString());
                        break;
                    case R.id.color4:
                        readpage.setBackgroundColor(getResources().getColor(R.color.ArticleBGColor4));
                        article.setTextColor(getResources().getColor(R.color.ArticleColor4));

                        editor.putInt("ac",R.color.ArticleColor4);
                        editor.putInt("abgc",R.color.ArticleBGColor4);
                        editor.apply();
                        Log.d("article",article.getTextColors().toString());
                        break;
                    case R.id.color5:
                        readpage.setBackgroundColor(getResources().getColor(R.color.ArticleBGColor5));
                        article.setTextColor(getResources().getColor(R.color.ArticleColor5));
                        editor.putInt("ac",R.color.ArticleColor5);
                        editor.putInt("abgc",R.color.ArticleBGColor5);
                        editor.apply();
                        break;
                    //三个底部导航按钮
//                    case R.id.mulu:
//
//                        break;
                    case R.id.font_set:
                        //File file = new File("/");
                        //调用系统文件管理器打开指定路径目录
                        break;
                    case R.id.danciben:
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("*/*"); //华为手机mate7不支持
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                        startActivityForResult(intent, 0);
                        break;
                }
            }
        };

        btnfont1.setOnClickListener(ReadSetOnClickListener);
        btnfont2.setOnClickListener(ReadSetOnClickListener);
        btc1.setOnClickListener(ReadSetOnClickListener);
        btc2.setOnClickListener(ReadSetOnClickListener);
        btc3.setOnClickListener(ReadSetOnClickListener);
        btc4.setOnClickListener(ReadSetOnClickListener);
        btc5.setOnClickListener(ReadSetOnClickListener);
        //btnmulu.setOnClickListener(ReadSetOnClickListener);
        btnfontset.setOnClickListener(ReadSetOnClickListener);
        btndanciben.setOnClickListener(ReadSetOnClickListener);
    }

    private View.OnTouchListener CenterOnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            mViewWidth = displayMetrics.widthPixels;
            mViewHeight = displayMetrics.heightPixels;
            //mViewWidth 是整个屏幕的宽度
            //就是在屏幕的一半+100和-100之间的宽度 同理高度
            boolean isCenterOfX = event.getX() < mViewWidth / 2 + 150
                    && event.getX() > mViewWidth / 2 - 150;
            boolean isCenterOfY = event.getY() < mViewHeight / 2 + 200
                    && event.getY() > mViewHeight / 2 - 200;
            //如果点击的位置是在这个方形之间
            if (isCenterOfX && isCenterOfY) {
                //必须要点击之后手指离开才进行监听
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Log.i("1", "onTouch: Center");
                    //回调方法 B中注册使用 A就是该Activity进行监听回调
                    if (mOnUserNeedSettingListener != null) {
                        mOnUserNeedSettingListener.onUserNeedSetting();
                    }
                }
                //返回true代表这个事件不向下分发，到这里就停止了
                //不会进行下面的方法了
                return true;
            }
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    FragmentManager fragmentManager =getFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    HeaderFragment HF = new HeaderFragment();
                    transaction.remove(HF);
                    transaction.commit();
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }
    };
    // 设置背景颜色变暗
    private void addBackground(PopupWindow popupWindow) {
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 1.0f;//调节透明度
        getWindow().setAttributes(lp);
        //dismiss时恢复原样
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                CommonUtil.setFullScreen(MainActivity.this);
                FragmentManager fragmentManager =getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                Fragment HF =  fragmentManager.findFragmentById(R.id.header_read);
                transaction.remove(HF);
                transaction.commit();
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
    }

    public String load(String filename){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            in = openFileInput(filename);
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line = reader.readLine())!= null){
                content.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(reader != null){
                    reader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return content.toString();
    }
    public void save(String content,String filename){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try{
            out = openFileOutput(filename,Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(content);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(writer != null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private void setServicePolicy(){
        TextView tvLoginPolicy = article;
        String itemStr = tvLoginPolicy.getText().toString();
        String serviceStr = "learned";
        String policyStr = "when";
        List<String> sp = new ArrayList<String>();
        sp.add("learn");
        sp.add("when");
        int indexService = itemStr.indexOf(serviceStr);
        int indexPolicy = itemStr.indexOf(policyStr);
        SpannableString spannableString = new SpannableString(itemStr);
        //遍历给定的字符串数组，如果在文章内则绑定事件
        for (String s : sp){
            if(itemStr.contains(s)){
                //颜色和点击事件
                int index = itemStr.indexOf(s);
                spannableString.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View view) {
                        Log.e("111", "clicked Service Terms");
                        Toast.makeText(MainActivity.this,"learn :学习",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void updateDrawState(TextPaint ds) {
                        //ds.setColor(Color.RED);
                        ds.setFakeBoldText(true);
                        ds.setUnderlineText(true);
                    }
                }, index, index + s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        //Privacy Policy 颜色和点击事件
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Log.e("111", "clicked Privacy Policy");
                Toast.makeText(MainActivity.this,"when :当什么什么的时候",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                //ds.setColor(Color.RED);
                ds.setFakeBoldText(true);
                ds.setUnderlineText(true);
            }
        }, indexPolicy, indexPolicy + policyStr.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvLoginPolicy.setText(spannableString);
        tvLoginPolicy.setMovementMethod(LinkMovementMethod.getInstance());

    }
    private String getMIMEType(File file) {

        String type="*/*";
        String fName = file.getName();
        //获取后缀名前的分隔符"."在fName中的位置。
        int dotIndex = fName.lastIndexOf(".");
        if(dotIndex < 0)
            return type;
        /* 获取文件的后缀名 */
        String fileType = fName.substring(dotIndex,fName.length()).toLowerCase();
        if(fileType == null || "".equals(fileType))
            return type;
        //在MIME和文件类型的匹配表中找到对应的MIME类型。
        for(int i=0;i<MIME_MapTable.length;i++){
            if(fileType.equals(MIME_MapTable[i][0]))
                type = MIME_MapTable[i][1];
        }
        return type;
    }
    private static final String[][] MIME_MapTable={
            //{后缀名，    MIME类型}
            {".3gp",    "video/3gpp"},
            {".apk",    "application/vnd.android.package-archive"},
            {".asf",    "video/x-ms-asf"},
            {".avi",    "video/x-msvideo"},
            {".bin",    "application/octet-stream"},
            {".bmp",      "image/bmp"},
            {".c",        "text/plain"},
            {".class",    "application/octet-stream"},
            {".conf",    "text/plain"},
            {".cpp",    "text/plain"},
            {".doc",    "application/msword"},
            {".docx",    "application/msword"},
            {".exe",    "application/octet-stream"},
            {".gif",    "image/gif"},
            {".gtar",    "application/x-gtar"},
            {".gz",        "application/x-gzip"},
            {".h",        "text/plain"},
            {".htm",    "text/html"},
            {".html",    "text/html"},
            {".jar",    "application/java-archive"},
            {".java",    "text/plain"},
            {".jpeg",    "image/jpeg"},
            {".JPEG",    "image/jpeg"},
            {".jpg",    "image/jpeg"},
            {".js",        "application/x-javascript"},
            {".log",    "text/plain"},
            {".m3u",    "audio/x-mpegurl"},
            {".m4a",    "audio/mp4a-latm"},
            {".m4b",    "audio/mp4a-latm"},
            {".m4p",    "audio/mp4a-latm"},
            {".m4u",    "video/vnd.mpegurl"},
            {".m4v",    "video/x-m4v"},
            {".mov",    "video/quicktime"},
            {".mp2",    "audio/x-mpeg"},
            {".mp3",    "audio/x-mpeg"},
            {".mp4",    "video/mp4"},
            {".mpc",    "application/vnd.mpohun.certificate"},
            {".mpe",    "video/mpeg"},
            {".mpeg",    "video/mpeg"},
            {".mpg",    "video/mpeg"},
            {".mpg4",    "video/mp4"},
            {".mpga",    "audio/mpeg"},
            {".msg",    "application/vnd.ms-outlook"},
            {".ogg",    "audio/ogg"},
            {".pdf",    "application/pdf"},
            {".png",    "image/png"},
            {".pps",    "application/vnd.ms-powerpoint"},
            {".ppt",    "application/vnd.ms-powerpoint"},
            {".pptx",    "application/vnd.ms-powerpoint"},
            {".prop",    "text/plain"},
            {".rar",    "application/x-rar-compressed"},
            {".rc",        "text/plain"},
            {".rmvb",    "audio/x-pn-realaudio"},
            {".rtf",    "application/rtf"},
            {".sh",        "text/plain"},
            {".tar",    "application/x-tar"},
            {".tgz",    "application/x-compressed"},
            {".txt",    "text/plain"},
            {".wav",    "audio/x-wav"},
            {".wma",    "audio/x-ms-wma"},
            {".wmv",    "audio/x-ms-wmv"},
            {".wps",    "application/vnd.ms-works"},
            //{".xml",    "text/xml"},
            {".xml",    "text/plain"},
            {".z",        "application/x-compress"},
            {".zip",    "application/zip"},
            {"",        "*/*"}
    };
}
