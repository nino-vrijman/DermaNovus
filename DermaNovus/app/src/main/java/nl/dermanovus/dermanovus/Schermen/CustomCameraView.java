package nl.dermanovus.dermanovus.Schermen;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @author Nino Vrijman
 */
public class CustomCameraView extends SurfaceView implements SurfaceHolder.Callback {

    private static android.hardware.Camera sCamera;
    public static Bitmap mBitmap;
    private SurfaceHolder holder;

    private static Camera.PictureCallback mPictureCallback;

    public CustomCameraView(Context context, AttributeSet attrs) {
        super(context, attrs);

        holder = getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

                mPictureCallback = new android.hardware.Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, android.hardware.Camera camera) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                mBitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
            }
        };
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            sCamera = android.hardware.Camera.open();
            sCamera.setDisplayOrientation(90);
            sCamera.setPreviewDisplay(holder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        try {
            android.hardware.Camera.Parameters parameters = sCamera.getParameters();
            if (parameters.getSupportedFocusModes().contains(
                    Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)) {
                parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
            }
            parameters.getSupportedPreviewSizes();
            sCamera.setParameters(parameters);
            sCamera.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (sCamera != null) {
            sCamera.stopPreview();
            sCamera.release();
            sCamera = null;
        }
    }

    public static void takeAPicture(){
        sCamera.takePicture(null, null, mPictureCallback);
    }
}
