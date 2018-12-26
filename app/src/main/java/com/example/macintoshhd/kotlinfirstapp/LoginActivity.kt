package com.example.macintoshhd.kotlinfirstapp

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.example.macintoshhd.kotlinfirstapp.`object`.Post
import com.example.macintoshhd.kotlinfirstapp.`object`.User
import com.example.macintoshhd.kotlinfirstapp.base.BaseActivity
import com.example.macintoshhd.kotlinfirstapp.base.MainPagerAdapter
import com.example.macintoshhd.kotlinfirstapp.base.PostRecyclerViewAdapter
import com.example.macintoshhd.kotlinfirstapp.fragmentstartup.SearchFragment
import com.example.macintoshhd.kotlinfirstapp.fragmentstartup.StartUpFragment
import java.util.ArrayList

class LoginActivity : BaseActivity(), PostRecyclerViewAdapter.ClickMoreListener {
    override fun OnClickMore() {
        when(rlBottomSheet.visibility == View.GONE) {
            true -> rlBottomSheet.visibility = View.VISIBLE
        }
    }

    lateinit var recyclerView: RecyclerView
    lateinit var rlBottomSheet: LinearLayout
    lateinit var dummyView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        recyclerView = findViewById(R.id.activitylogin_rcv)
        dummyView = findViewById(R.id.activity_login_iv_dummy)
        rlBottomSheet = findViewById(R.id.activity_login_rl_bottomsheet)

        dummyView.setOnClickListener {
            when(rlBottomSheet.visibility == View.VISIBLE) {
                true -> rlBottomSheet.visibility = View.GONE
            }
        }

        val userCurrent : User = User()
        userCurrent.name = "Admin"
        userCurrent.role = "Admin"
        userCurrent.current = true
        val user1 : User = User()
        user1.name = "John Cena"
        user1.role = "Manager"
        val user2 : User = User()
        user2.name = "Will Smith"
        user2.role = "Director"
        val post1 : Post = Post()
        post1.comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequaDuis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumipsum dolor sit amet, consectetur"
        post1.user = userCurrent
        val post2 : Post = Post()
        post2.comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequaDuis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumipsum dolor sit amet, consectetur"
        post2.user = user2
        val post3 : Post = Post()
        post3.comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequaDuis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumipsum dolor sit amet, consectetur"
        post3.user = user1
        val post4 : Post = Post()
        post4.comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequaDuis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumipsum dolor sit amet, consectetur"
        post4.user = user2
        var listPost: List<Post> = listOf(post1, post2, post3, post4)
        recyclerView.setLayoutManager(LinearLayoutManager(this@LoginActivity));
        recyclerView.adapter = PostRecyclerViewAdapter(listPost, this)
    }


}
