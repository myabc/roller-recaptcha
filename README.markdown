Roller reCAPTCHA Plugin
=======================

Prerequisites
-------------

* JDK 1.5 or greater.
* Roller 4.0 or greater.

Copyright and Licensing
-----------------------

The source code to this plugin is released under an **Apache 2.0 License**.

> Copyright 2008 Alex Coles.

A copy of the License may be found in the accompanying APACHE-LICENSE-2.0 file.

This plugin bundles the [ReCaptcha Java Library](http://tanesha.net/projects/recaptcha4j/),
from Tanesha Networks.

Installation
------------

### Install files

You can use the installer script provided to perform the file installation for you:
    `ROLLER_INSTALL_DIR=/usr/local/tomcat/webapps/roller ./install.sh`

Or, if you prefer a manual installation, copy the following libraries to your
`ROLLER_INSTALL_DIR/WEB-INF/lib`: 

* `recaptcha4j-0.0.7.jar`: _the ReCaptcha Java Library_
* `roller-recaptcha.jar`: _this plugin_

### Configuration

1.  Edit your `roller-custom.properties` with your favourite editor. If you
    installed Roller to Tomcat for example, your Roller configuration will
    most likely be found in `$CATALINA_HOME/common/classes/roller-custom.properties`.

    You'll need to go to http://recaptcha.net/ and get the API keys. Once you've
    done that, set the following property in your roller-custom.properties:

    `comment.authenticator.recaptcha.key_public=<get one at recaptcha.com>`
    `comment.authenticator.recaptcha.key_private=<get one at recaptcha.com>`

    and make the ReCaptchaCommentAuthenticator your comment authenticator:

    `comment.authenticator.classname=\`
    `com.ikonoklastik.roller.ui.plugins.comments.recaptcha.ReCaptchaCommentAuthenticator`

2.  Once you're done, restart your Roller web application. Ensure that comments
    are enabled in your site-wide settings.

### Building the Source

This plugin was developed with the NetBeans IDE. A NetBeans project is included
along with the source code.

To compile the Roller reCAPTCHA plugin, you'll need to download either the Roller
source or binaries:

    wget http://apache.mult	idist.com/roller/roller-4/v4.0.0/bin/apache-roller-4.0.zip
    unzip apache-roller-4.0.zip

The plugin has the following dependencies, which you will need to include in
your compile path:

* roller-business
* roller-core
* roller-web
* commons-httpclient
* commons-logging
* Servlet API

_More detailed instructions for building the source will be added._

Support
-------

Use is at your own risk. Comments, feedback and patches are welcome though. You
can contact the developer at <alex@alexcolesportfolio.com>.
