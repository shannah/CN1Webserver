/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.webserver;

import com.codename1.system.NativeLookup;
import java.io.IOException;

/**
 *
 * @author shannah
 */
public class WebServer {
    private NativeWebServer peer;
    private String docRoot;
    private int port;
    
    public WebServer(String docRoot, int port) {
        this.docRoot = docRoot;
        this.port = port;
        peer = NativeLookup.create(NativeWebServer.class);
    }
    
    public boolean isSupported() {
        return peer != null && peer.isSupported();
    }
    
    public boolean isRunning() {
        return isSupported() && peer.isRunning();
    }
    
    public void start() {
        peer.start(docRoot, port);
        
    }
    
    public void stop() {
        peer.stop();
    }
}
