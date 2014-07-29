package org.openblend.nophonespam;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;



public class CallReciever extends BroadcastReceiver {

    private Context mContext;
    private Intent mIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        mIntent = intent;
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        int events = PhoneStateListener.LISTEN_CALL_STATE;
        tm.listen(phoneStateListener, events);
    }

    private final PhoneStateListener phoneStateListener = new PhoneStateListener() {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            String callState = "UNKNOWN";
            switch (state) {
                case TelephonyManager.CALL_STATE_IDLE:
                    callState = "IDLE";
                    break;
                case TelephonyManager.CALL_STATE_RINGING:{

                    Toast.makeText(mContext, "Incoming Call- " + incomingNumber, Toast.LENGTH_LONG).show();
                        callState = "Incoming - Ringing (" + incomingNumber+ ")";

                    break;}

                case TelephonyManager.CALL_STATE_OFFHOOK:
                    String dialingNumber = mIntent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

                        Toast.makeText(mContext, "Incoming Call - " + dialingNumber,Toast.LENGTH_LONG).show();
                        callState = "Incoming - Dialing (" + dialingNumber + ")";


                    break;
            }
            Log.i(">>>Broadcast", "onCallStateChanged " + callState);
            super.onCallStateChanged(state, incomingNumber);
        }
    };

}