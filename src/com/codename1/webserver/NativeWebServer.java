/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.webserver;

import com.codename1.system.NativeInterface;

/**
 *
 * @author shannah
 */
public interface NativeWebServer extends NativeInterface {
    public boolean isRunning();
    public boolean start(String docRoot, int port);
    public boolean stop();
}
