package com.whytecreations.qsn.ui.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.RippleDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.activity.viewModels
import androidx.annotation.ColorInt
import androidx.annotation.StyleRes
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.ListPopupWindow
import androidx.appcompat.widget.Toolbar
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.doOnLayout
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.ActivityDashBoardBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.nads.curved_bottom_navigation.CbnMenuItem
import com.nads.curved_bottom_navigation.CurvedBottomNavigationView
import com.nads.curved_bottom_navigation.getColorRes
import com.whytecreations.qsn.viewmodels.BaseViewModel
import com.whytecreations.qsn.viewmodels.HomeActViewModel
import com.whytecreations.qsn.viewmodels.ViewModelFactory


class DashBoardActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var navController:NavController
    private lateinit var  binding: ActivityDashBoardBinding
    private lateinit var toolbars: Toolbar
    private lateinit var navview: NavigationView
    private val viewModel:BaseViewModel by viewModels()
    private val activityViewModel: HomeActViewModel by viewModels { ViewModelFactory.getInstance() }
    private lateinit var listener:NavController.OnDestinationChangedListener
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding:ActivityDashBoardBinding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbars = binding.toolbar
        setSupportActionBar(toolbars)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.viewModel = activityViewModel
        binding.lifecycleOwner = this





        drawerLayout = binding.drawerLayout
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_dashboard) as NavHostFragment
        navview = binding.navView
        navController = navHostFragment.navController
        val navigation = binding.navView
        setupWithNavController (navigation,navController)


       //toolbars.setTitle("QSND")
        toolbars.setTitleTextColor(Color.parseColor("#FFFFFF"))
        toolbars.isVisible = true




        val menuItems = arrayOf(
            CbnMenuItem(
                R.drawable.homepath,
                R.drawable.homepath,
                R.id.dashBoard
            ),
            CbnMenuItem(
                R.drawable.addanime,
                R.drawable.addanime,
             // R.id.auctionListCarNumber

            ),
      CbnMenuItem(
            R.drawable.sedananim,
            R.drawable.sedananim,
          R.id.carLists
        ),
            CbnMenuItem(
                R.drawable.auctionanime,
                R.drawable.auctionanime,
                R.id.auctionLists
            )
        )
       //
        appBarConfiguration = AppBarConfiguration(
            setOf(
               R.id.myProfile,
               R.id.auctionLists,
                R.id.dashBoard,
                R.id.auctionListCarNumber,
                R.id.carLists
            ),drawerLayout
        )
        binding.bottomNavigationViewmain.setOnMenuItemClickListener { cbnMenuItem, index ->
            when(index) {
                0 -> navController.navigate(R.id.dashBoard)
                1 -> change(binding.bottomNavigationViewmain,Color.parseColor("#E8AF51"),speedDialItems())
                2 -> navController.navigate(R.id.carLists)
                3 -> navController.navigate(R.id.auctionLists)

            }
        }
        binding.bottomNavigationViewmain.setMenuItems(menuItems)
      //  binding.bottomNavigationViewmain.setupWithNavController(navController)



       setupActionBarWithNavController(navController, appBarConfiguration)



    }



    private fun change(button: View, @ColorInt tint: Int = Color.BLUE, items: List<Pair<String,
            Drawable?>>) {
        navController.navigate(R.id.auctionLists)
        speedDial(anchor = button, tint = tint, items = items)
    }
    val color = Color.BLUE
    private fun speedDialItems(): List<Pair<String, Drawable?>> = this.run {
        listOf(
            getString(R.string.option_1) to getDrawable(R.drawable.sedanedited),
            getString(R.string.option_2) to getDrawable(R.drawable.auctionedited),)

    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
//===========================================


    /**
     * Pops an orphaned [View] over the specified [anchor] using a [PopupWindow]
     */
    fun View.popOver(
        anchor: View,
        adjuster: () -> Point = { Point(330, -350) },
        options: PopupWindow.() -> Unit = {}
    ) {
        require(!this.isAttachedToWindow) { "The View being attached must be an orphan" }
        PopupWindow(this.wrapAtAnchor(anchor, adjuster), ListPopupWindow.MATCH_PARENT, ListPopupWindow.MATCH_PARENT, true)
            .run {
                isOutsideTouchable = true
                contentView.setOnTouchListener { _, _ -> dismiss(); true }
                options(this)
                showAtLocation(anchor, Gravity.START, 0, 0)
            }
    }

    private fun View.wrapAtAnchor(anchor: View, adjuster: () -> Point): View? =
        FrameLayout(anchor.context).apply {
            this@wrapAtAnchor.alignToAnchor(anchor, adjuster)
            addView(this@wrapAtAnchor, ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ))
        }

    private fun View.alignToAnchor(anchor: View, adjuster: () -> Point) = intArrayOf(0, 0)
        .run {
            anchor.getLocationInWindow(this)
            doOnLayout {
                val (offsetX, offsetY) = adjuster()
                val x = this[0].toFloat() + offsetX
                val y = this[1].toFloat() + offsetY
                translationX = x; translationY = y
            }
        }


    companion object{
        private const val MIRROR = 180F
        private const val INITIAL_DELAY = 0.15F
        //========Animation
        private const val SPEED_DIAL_TRANSLATION_Y = -0.2F
        private const val SPEED_DIAL_SCALE_PIVOT = 0.5F
        private const val SPEED_DIAL_SCALE = 0.5F
    }

    private val translucentBlack = Color.argb(50, 0, 0, 0)

    fun speedDial(
        anchor: View,
        @SuppressLint("ResourceType") @ColorInt tint: Int =
            anchor.context.getColorRes(R.attr.colorPrimary),
        @StyleRes animationStyle: Int =
            android.R.style.Animation_Dialog,
        layoutAnimationController: LayoutAnimationController =
            LayoutAnimationController(speedDialAnimation,
                INITIAL_DELAY)
                .apply { order = LayoutAnimationController.ORDER_NORMAL },
        items: List<Pair<String, Drawable?>>,
       // dismissListener: (Int?) -> Unit
    ) = LinearLayout(anchor.context).run root@{
        rotationY = MIRROR
        rotationX = MIRROR
        clipChildren = false
        clipToPadding = false
        orientation = LinearLayout.VERTICAL
        layoutAnimation = layoutAnimationController


        popOver(anchor = anchor) popUp@{
            this.animationStyle = animationStyle
            var dismissReason: Int? = null
           // setOnDismissListener { dismissListener(dismissReason) }

            items.mapIndexed { index, pair ->  speedDialLayout(pair, tint, View.OnClickListener {
                dismissReason = index; dismiss()
            if (index.equals(0))navController.navigate(R.id.addAnAdvert)
            else navController.navigate(R.id.auctionListCarNumber)}) }
                .forEach(this@root::addView)
        }
    }

    private fun LinearLayout.speedDialLayout(
        pair: Pair<String, Drawable?>, tint: Int,
        clickListener: View.OnClickListener) =
        LinearLayout(context).apply {
            rotationY = MIRROR
            rotationX = MIRROR
            clipChildren = false
            clipToPadding = false
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            updatePadding(bottom = context.resources.getDimensionPixelSize(R.dimen.activity_horizontal_margin))
            setOnClickListener(clickListener)

            //addView(speedDialLabel(tint, pair.first, clickListener))
            addView(speedDialFab(tint, pair, clickListener))
        }

    private fun LinearLayout.speedDialLabel(tint: Int, label: CharSequence?,
                                            clicker: View.OnClickListener) =
        AppCompatTextView(context).apply {
            val dp4 = context.resources.getDimensionPixelSize(R.dimen.quarter_margin)
            val dp8 = context.resources.getDimensionPixelSize(R.dimen.half_margin)

            isClickable = true
            background = context.ripple(tint) { setAllCornerSizes(dp8.toFloat()) }

            isVisible = label != null
            text = label

            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                marginEnd = context.resources.getDimensionPixelSize(R.dimen.single_margin)
                gravity = Gravity.CENTER_VERTICAL
            }

            updatePadding(left = dp8, top = dp4, right = dp8, bottom = dp4)
            setOnClickListener(clicker)
        }

    private fun LinearLayout.speedDialFab(
        tint: Int, pair: Pair<String, Drawable?>,
        clicker: View.OnClickListener) =
        AppCompatImageButton(context).apply {
            val dp40 = context.resources.getDimensionPixelSize(R.dimen.double_and_half_margin)
            imageTintList = null
            background = context.ripple(tint) { setAllCornerSizes(dp40.toFloat()) }
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_VERTICAL
                height = dp40
                width = dp40

            }

            setOnClickListener(clicker)
            setImageDrawable(if (pair.second !is BitmapDrawable) BitmapDrawable(context.resources, pair.second?.toBitmap()) else pair.second)
        }

    private fun View.getOffset(anchor: View): () -> Point = {
        val dp40 = context.resources.getDimensionPixelSize(R.dimen.double_and_half_margin)
        val halfAnchorWidth = (anchor.width / 2)
        val halfMiniFabWidth = (dp40 / 2)
        val xOffset = if (width > anchor.width) halfAnchorWidth + halfMiniFabWidth - width else halfAnchorWidth - halfMiniFabWidth

        Point(xOffset, -(anchor.height / 2) - height)
    }

    private fun Context.ripple(tint: Int, shapeModifier: ShapeAppearanceModel.Builder.() -> Unit): RippleDrawable = RippleDrawable(
        ColorStateList.valueOf(translucentBlack),
        MaterialShapeDrawable(ShapeAppearanceModel.builder().run {
            shapeModifier(this)
            build()
        }).apply {
            tintList = ColorStateList.valueOf(tint)
            setShadowColor(Color.DKGRAY)
            initializeElevationOverlay(this@ripple)
        },
        null
    )


//====================================================

    private val speedDialAnimation: Animation
        get() = AnimationSet(false).apply {
            duration = 200L
            addAnimation(alpha())
            addAnimation(scale())
            addAnimation(translate())
        }

    private fun alpha() = AlphaAnimation(0F, 1F).accelerateDecelerate()

    private fun translate(): Animation = TranslateAnimation(
        Animation.RELATIVE_TO_PARENT,
        0F,
        Animation.RELATIVE_TO_PARENT,
        0F,
        Animation.RELATIVE_TO_PARENT,
        SPEED_DIAL_TRANSLATION_Y,
        Animation.RELATIVE_TO_PARENT,
        0F
    ).accelerateDecelerate()

    private fun scale(): Animation = ScaleAnimation(
        SPEED_DIAL_SCALE,
        1F,
        SPEED_DIAL_SCALE,
        1F,
        Animation.RELATIVE_TO_SELF,
        SPEED_DIAL_SCALE_PIVOT,
        Animation.RELATIVE_TO_SELF,
        SPEED_DIAL_SCALE_PIVOT
    ).accelerateDecelerate()
    private fun Animation.accelerateDecelerate() = apply{
        interpolator = AccelerateDecelerateInterpolator() }


}