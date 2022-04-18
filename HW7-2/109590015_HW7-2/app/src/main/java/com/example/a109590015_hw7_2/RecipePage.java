package com.example.a109590015_hw7_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

public class RecipePage extends Activity {

    public static int index = 0;

    int[] images = {R.drawable.one, R.drawable.two};

    String[] descriptions = {
            "卡邦尼蘑菇醬 carbonara mushroom—1/2罐(150g)" +
                    "，牛奶 Milk—100cc" +
                    "，雞腿肉 Chicken thigh—1片洋蔥 Onion—1/4個" +
                    "，香菇 Shitake—3片" +
                    "，花椰菜,汆燙過 Broccoli,blanched—5個" +
                    "，白飯 Steamed rice—1碗" +
                    "，鹽巴&黑胡椒 Salt&Pepper\n" +
                    "1. 汆燙過的花椰菜切成小塊。\n" +
                    "\n" +
                    "2. 洋蔥切成薄片。\n" +
                    "\n" +
                    "3. 泡水過的乾燥香菇切成薄片。\n" +
                    "\n" +
                    "4. 雞腿肉切成小塊。\n" +
                    "\n" +
                    "5. 平底鍋開中火 把雞肉皮面朝下放進去。\n" +
                    "\n" +
                    "6. 加入準備好的花椰菜攪拌一下就可以熄火裝盤喔！",
            "芒果 110g\n" + "細砂糖 40g\n" + "鮮奶油 90g\n" + "牛奶 130g\n" + "吉力丁 5g\n" +
                    "1. 芋頭備用\n" +
                    "2. 芋頭加牛奶30g牛奶打成芋頭奶用芋頭奶酪上面的部分取用，取出後過篩讓口感绵密\n" +
                    "3. 其於牛奶加入砂糖不煮滾，扮勻無顆粒就行了\n" +
                    "4. 吉力丁片泡冰水軟化，擠乾放入3\n" +
                    "5. 2,3,4混和後杯子分裝入冷藏\n" +
                    "6. 冰讓其成固狀不流動即可\n" +
                    "7. 上述方法去除芋頭部分就是原味的方法。一樣成固狀即可裝飾芋頭或自己喜愛的水果"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_page);
        ImageView imageview = findViewById(R.id.imageView2);
        imageview.setImageResource(images[index]);
        TextView textView = findViewById(R.id.textView4);
        textView.setText(descriptions[index]);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
