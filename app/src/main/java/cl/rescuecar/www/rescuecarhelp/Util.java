package cl.rescuecar.www.rescuecarhelp;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Jvega on 29-05-2017.
 */

public final class Util {
    /**
     * clase para colapsar la vista de una lista
     * @param v vista
     */
    public static void collapse(final View v, int animationTime) {
        final int initialHeight = v.getMeasuredHeight();
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(Float.compare(interpolatedTime, 1.f) == 0){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration(animationTime);
        v.startAnimation(a);
    }

    /**
     * clase para expandir una vista de la lista.
     * @param v vista
     */
    public static void expand(final View v, int animationTime) {
        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int targtetHeight = v.getMeasuredHeight();

        v.getLayoutParams().height = 0;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (Float.compare(interpolatedTime, 1.f) == 0) {
                    v.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                } else {
                    v.getLayoutParams().height = (int)(targtetHeight * interpolatedTime);
                }
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration(animationTime);
        v.startAnimation(a);
    }
}
