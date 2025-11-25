package com.example.finisherhandbook

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    var adapter: MyAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var rcView = findViewById<RecyclerView>(R.id.rcView)

        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.setNavigationItemSelectedListener (this)


        var list = ArrayList<ListItem>()

        list.addAll(fillArrays(resources.getStringArray(R.array.fish),
            resources.getStringArray(R.array.fish_content),
            getImageId(R.array.fish_image_array)))

        /*list.add(ListItem(R.drawable.som, "Сом", "описание сома"))
        list.add(ListItem(R.drawable.nalim, "Налим", "описание налима"))
        list.add(ListItem(R.drawable.shuca, "Щука", "описание щуки"))
        list.add(ListItem(R.drawable.caras, "Карась", "описание карася"))*/
        // это было чисто для проверки до автоматического заполнения
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var drawerLayout: DrawerLayout? = null
        drawerLayout = findViewById(R.id.drawerLayout)

        when(item.itemId){
            // adapter.updateAdapter()
            R.id.id_Fish -> {
                Toast.makeText(this,"Id Fish",Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fish),
                    resources.getStringArray(R.array.fish_content),
                    getImageId(R.array.fish_image_array)))
            }
            R.id.id_na -> {
                Toast.makeText(this,"Id na",Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.na),
                    resources.getStringArray(R.array.na_content),
                    getImageId(R.array.na_image_array)))
            }
            R.id.id_sna -> Toast.makeText(this,"Id sna",Toast.LENGTH_LONG).show()
            R.id.id_history -> Toast.makeText(this,"Id history",Toast.LENGTH_LONG).show()

        }
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }

    fun fillArrays(tittleArray:Array<String>, contentArray:Array<String>, imageArray:IntArray):List<ListItem> {
        var listItemArray = ArrayList<ListItem>()
        for(n in 0..tittleArray.size - 1) {
            var listItem = ListItem(imageArray[n], tittleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId: Int): IntArray {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices) {
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }


}