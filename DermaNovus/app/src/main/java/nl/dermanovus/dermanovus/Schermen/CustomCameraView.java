package nl.dermanovus.dermanovus.Schermen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    public CustomCameraView(Context context, AttributeSet attrs) {
        super(context, attrs);

        holder = getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
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
            parameters.getSupportedPreviewSizes();
            sCamera.setParameters(parameters);
            sCamera.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        sCamera.stopPreview();
        sCamera.release();
    }

    public static Bitmap takeAPicture(){
        android.hardware.Camera.PictureCallback mPictureCallback = new android.hardware.Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, android.hardware.Camera camera) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                mBitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
            }
        };
        sCamera.takePicture(null, null, mPictureCallback);
        return mBitmap;
    }
}
