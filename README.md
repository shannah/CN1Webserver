# CN1Webserver Module

Run an embedded webserver inside your [Codename One](https://www.codenameone.com) application.  Supports iOS, Android, and JavaSE (simulator).

## Installation

Install via Codename One Settings, or by downloading and copying the CN1Webserver.cn1lib module into your project's lib directory, then right click on your project and select "Codename One > Refresh Cn1libs".

### iOS Transport Settings

If you want to "consume" the web server in your app in a BrowserComponent or ConnectionRequest, you need to add some transport exceptions to your info.plist.  You should add the following to the `ios.plistInject` build hint:

~~~~
<key>NSAppTransportSecurity</key>
    <dict>
        <key>NSExceptionDomains</key>
        <dict>
            <key>localhost</key>
            <dict>
                <key>NSTemporaryExceptionAllowsInsecureHTTPSLoads</key>
                <false/>
                <key>NSIncludesSubdomains</key>
                <true/>
                <key>NSTemporaryExceptionAllowsInsecureHTTPLoads</key>
                <true/>
                <key>NSTemporaryExceptionMinimumTLSVersion</key>
                <string>1.0</string>
                <key>NSTemporaryExceptionRequiresForwardSecrecy</key>
                <false/>
            </dict>
        </dict>
    </dict>
~~~~

## Usage

~~~~
// Start the webserver
WebServer server = new WebServer(
  new File("httpdocs").getAbsolutePath(), // Path to doc root in FileSystemStorage
  8888 // Port
);
if (server.isSupported()) {
  // Check that the platform supports the server.
  server.start();
}


// Access the server in a BrowserComponent
BrowserComponent bc = new BrowserComponent();
bc.setURL("http://localhost:8888/index.html");
    // NOTE: On iOS, you need to add localhost exceptions
    // to the transport settings in order access localhost URLs


// Stop server if you don't need it anymore
server.stop();
~~~~

## Demo App

Check out the demo app in [CN1WebserverDemo.java](CN1WebserverDemo/src/com/codename1/webserver/demo/CN1WebserverDemo.java)

## Credits

* CN1Lib created by Steve Hannah, Codename One
* On iOS it uses the fantastic [GCDWebServer](https://github.com/swisspol/GCDWebServer)
