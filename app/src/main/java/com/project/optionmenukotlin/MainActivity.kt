package com.project.optionmenukotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(btnContextMenu)

        btnContextMenu.setOnLongClickListener {
            openContextMenu(btnContextMenu)
            true
        }

        btnPopUpMenu.setOnClickListener {

            val popup = PopupMenu(this@MainActivity, btnPopUpMenu)
            //Inflating the Popup using xml file
            popup.menuInflater.inflate(R.menu.pop_up, popup.menu)

            popup.setOnMenuItemClickListener({
                if (it.itemId == R.id.one) {
                    Toast.makeText(applicationContext, "One", Toast.LENGTH_SHORT).show()
                } else if(it.itemId == R.id.two) {
                    Toast.makeText(applicationContext, "Two", Toast.LENGTH_SHORT).show()
                }else if(it.itemId == R.id.three) {
                    Toast.makeText(applicationContext, "Three", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, "None", Toast.LENGTH_SHORT).show()
                }
                true
            })

            popup.show()//showing popup menu

        }

        btnPopUpMenuGroup.setOnClickListener {

            val popup = PopupMenu(this@MainActivity, btnPopUpMenu)
            //Inflating the Popup using xml file
            popup.menuInflater.inflate(R.menu.popup_group, popup.menu)


            popup.setOnMenuItemClickListener({
                if (it.itemId == R.id.four && it.isChecked) {
                    Toast.makeText(applicationContext, "Four. Was Checked", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, it.title, Toast.LENGTH_SHORT).show()
                }
                true
            })
            popup.show()

        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Context Menu")
        menu?.add(0, v?.id!!, 0, "Call")
        menu?.add(1, v?.id!!, 1, "SMS")
        menu?.add(2, v?.id!!, 2, "Search")

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when {
            item?.title == "Call" -> {
                Toast.makeText(this@MainActivity, "Call", Toast.LENGTH_LONG).show()
                return true
            }
            item?.title == "SMS" -> {
                Toast.makeText(this@MainActivity, "SMS", Toast.LENGTH_LONG).show()
                return true
            }
            item?.title == "Search" -> {
                Toast.makeText(this@MainActivity, "Search", Toast.LENGTH_LONG).show()
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add -> {
                Log.d("API123", "done")
                return true
            }
            R.id.call -> {
                Log.d("API123", "done")
                return true
            }
            R.id.day -> {
                Log.d("API123", "done")
                return true
            }
            R.id.compass -> {
                Log.d("API123", "done")
                return true
            }

            R.id.agenda -> {
                Log.d("API123", "done")
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }

    }
}