package com.example.something;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class ShakeDetector implements SensorEventListener {

    private static final float SHAKE_THRESHOLD_GRAVITY = 1.2F;
    private static final int SHAKE_SLOP_TIME_MS = 500;
    private static final int SHAKE_COUNT_RESET_TIME_MS = 3000;

    private OnShakeListener listener;
    private long shakeTimestamp;
    private int shakeCount;

    public void setOnShakeListener(OnShakeListener listener) {
        this.listener = listener;
    }

    public interface OnShakeListener {
        void onShake(int count);
    }

    public int getShakeCount() {
        return shakeCount;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // ignore
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (listener != null) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float gravityX = x / SensorManager.GRAVITY_EARTH;
            float gravityY = y / SensorManager.GRAVITY_EARTH;
            float gravityZ = z / SensorManager.GRAVITY_EARTH;

            //gravity force will be close to 1 when there is no movement
            float force = (float) Math.sqrt(gravityX * gravityX + gravityY * gravityY + gravityZ * gravityZ);

            if (force > SHAKE_THRESHOLD_GRAVITY) {
                final long now = System.currentTimeMillis();
                // ignore shake events too close to each other (500ms)
                if (shakeTimestamp + SHAKE_SLOP_TIME_MS > now) {
                    return;
                }

                // reset the shake count after 3 seconds of no shakes
                if (shakeTimestamp + SHAKE_COUNT_RESET_TIME_MS < now) {
                    shakeCount = 0;
                }

                shakeTimestamp = now;
                shakeCount++;

                listener.onShake(shakeCount);
            }
        }
    }
}