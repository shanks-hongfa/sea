package com.shanks.test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.shanks.urirouter.base.Dns;
import com.shanks.urirouter.base.Router;

/**
 * Created by shanksYao on 9/15/15.
 */
public class RouterRegister implements Router.Register {

    @Override
    public void init() {

        Router router = new Router(new Router.Render() {
            @Override
            public boolean render(Context context, Uri uri) {
                Toast.makeText(context, uri.toString() + "*****default*****test", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        Dns.register("shanks.uri", router);
        router.addRouterDir("/test", new Router.Render() {
            @Override
            public boolean render(Context context, Uri uri) {
                Toast.makeText(context, uri.toString() + "-----default-----test", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        router.addRouter("/test/main", new Router.Render() {
            @Override
            public boolean render(Context context, Uri uri) {
                context.startActivity(new Intent(context,MainActivity.class));
                return true;
            }
        });
    }
}
