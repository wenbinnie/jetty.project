//
//  ========================================================================
//  Copyright (c) 1995-2018 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.websocket.jsr356.tests.framehandlers;

import java.nio.ByteBuffer;

import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.websocket.common.AbstractWholeMessageHandler;
import org.eclipse.jetty.websocket.core.frames.Frame;
import org.eclipse.jetty.websocket.core.frames.OpCode;
import org.eclipse.jetty.websocket.core.io.BatchMode;

public class WholeMessageEcho extends AbstractWholeMessageHandler
{
    @Override
    public void onWholeBinary(ByteBuffer wholeMessage, Callback callback)
    {
        super.onWholeBinary(wholeMessage, callback);
        channel.sendFrame(new Frame(OpCode.BINARY).setPayload(wholeMessage), callback, BatchMode.OFF);
    }

    @Override
    public void onWholeText(String wholeMessage, Callback callback)
    {
        super.onWholeText(wholeMessage, callback);
        channel.sendFrame(new Frame(OpCode.TEXT).setPayload(wholeMessage), callback, BatchMode.OFF);
    }
}
