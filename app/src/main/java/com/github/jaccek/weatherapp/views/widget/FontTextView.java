package com.github.jaccek.weatherapp.views.widget;

        import android.annotation.TargetApi;
        import android.content.Context;
        import android.content.res.TypedArray;
        import android.graphics.Typeface;
        import android.os.Build;
        import android.util.AttributeSet;
        import android.widget.TextView;

        import com.github.jaccek.weatherapp.R;

/**
 * {@link TextView} with changeable font from layout files.
 */
public class FontTextView extends TextView
{
    public FontTextView(Context context)
    {
        super(context);
        init(null);
    }

    public FontTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(attrs);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet pAttributeSet)
    {
        // we don't have attributes or we are in edit mode? -> nothing to do
        if (pAttributeSet == null || isInEditMode())
        {
            return;
        }

        // get custom font
        TypedArray array = getContext().getTheme().obtainStyledAttributes(pAttributeSet, R.styleable.FontTextView, 0, 0);
        String fontName = null;
        try
        {
            fontName = array.getString(R.styleable.FontTextView_customFont);
        }
        finally
        {
            array.recycle();
        }

        // we don't have custom font? -> nothing to do
        if (fontName == null)
        {
            return;
        }

        // get typeface
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName + ".ttf");

        // no typeface? -> nothing to do
        if (typeface == null)
        {
            return;
        }

        // set typeface
        setTypeface(typeface);
    }
}
