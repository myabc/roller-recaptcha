/*
 * Copyright 2008 Alex Coles, Ikonoklastik Productions
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ikonoklastik.roller.ui.plugins.comments.recaptcha;

import javax.servlet.http.HttpServletRequest;
import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;
import net.tanesha.recaptcha.ReCaptchaResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.roller.weblogger.config.WebloggerConfig;
import org.apache.roller.weblogger.ui.rendering.plugins.comments.CommentAuthenticator;

/**
 *
 * @author alexbcoles
 */
public class ReCaptchaCommentAuthenticator implements CommentAuthenticator {

    private static Log log = LogFactory.getLog(ReCaptchaCommentAuthenticator.class);
    public final String privateApiKey;
    public final String publicApiKey;

    public ReCaptchaCommentAuthenticator() {
        privateApiKey = WebloggerConfig.getProperty("comment.authenticator.recaptcha.apikey_private");
        publicApiKey = WebloggerConfig.getProperty("comment.authenticator.recaptcha.apikey_public");
    }

    public String getHtml(HttpServletRequest request) {

        ReCaptcha captcha = ReCaptchaFactory.newReCaptcha(publicApiKey, privateApiKey, false);
        String captchaScript = captcha.createRecaptchaHtml(request.getParameter("error"), null);

        return captchaScript;
    }

    public boolean authenticate(HttpServletRequest request) {

        ReCaptcha captcha = ReCaptchaFactory.newReCaptcha(publicApiKey, privateApiKey, false);
        ReCaptchaResponse response = captcha.checkAnswer(request.getRemoteAddr(), request.getParameter("recaptcha_challenge_field"), request.getParameter("recaptcha_response_field"));

        if (!response.isValid()) {
            log.error(response.getErrorMessage());
        }

        return response.isValid();
    }

}
