##CircleIndicator
a CircleIndicator view 

An email <yiflandre@gmail.com> link

##setup
gradle

```
compile 'com.lianggekeji.yhj:circleindicator:2.0.0'
	
```

##usage

![badge1](http://i1.piimg.com/4851/8090a936001fe287.png) 



 in xml:
 
```
   <com.lianggekeji.circleindicator.CircleIndicator
        android:id="@+id/indicator"
        android:background="@color/colorAccent"
        app:radius="10dp"
        app:space="10dp"
        app:selectedColor="#23d"
        app:unSelectedColor="#7d6"
        app:gravity="right"
        android:paddingTop="5dp"
        android:paddingBottom="10dp"
        android:layout_width="300dp"
        android:layout_height="wrap_content"/>

```


 just in java
 
```
    final CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
    indicator.setupViewPager(viewpager);
    indicator.setCount(8);

```

 
 
##attr
 ```
  <declare-styleable name="indicator">
        <attr name="radius" format="dimension"/>
        <attr name="space" format="dimension"/>
        <attr name="selectedColor" format="color" />
        <attr name="unSelectedColor" format="color" />
        <attr name="gravity" format="enum">
            <enum name="left" value="0"/>
            <enum name="center" value="1"/>
            <enum name="right" value="2"/>
        </attr>
    </declare-styleable>
 ```

