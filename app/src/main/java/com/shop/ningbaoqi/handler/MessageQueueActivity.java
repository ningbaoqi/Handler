package com.shop.ningbaoqi.handler;

import android.os.Binder;
import android.os.Bundle;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MessageQueueActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    MessageQueue插入数据方法；就是单链表的插入操作

//    boolean enqueueMessage(Message msg, long when) {
//        if (msg.target == null) {
//            throw new IllegalArgumentException("Message must have a target.");
//        }
//        if (msg.isInUse()) {
//            throw new IllegalStateException(msg + " This message is already in use.");
//        }
//
//        synchronized (this) {
//            if (mQuitting) {
//                IllegalStateException e = new IllegalStateException(
//                        msg.target + " sending message to a Handler on a dead thread");
//                Log.w(TAG, e.getMessage(), e);
//                msg.recycle();
//                return false;
//            }
//
//            msg.markInUse();
//            msg.when = when;
//            Message p = mMessages;
//            boolean needWake;
//            if (p == null || when == 0 || when < p.when) {
//                // New head, wake up the event queue if blocked.
//                msg.next = p;
//                mMessages = msg;
//                needWake = mBlocked;
//            } else {
//                // Inserted within the middle of the queue.  Usually we don't have to wake
//                // up the event queue unless there is a barrier at the head of the queue
//                // and the message is the earliest asynchronous message in the queue.
//                needWake = mBlocked && p.target == null && msg.isAsynchronous();
//                Message prev;
//                for (;;) {
//                    prev = p;
//                    p = p.next;
//                    if (p == null || when < p.when) {
//                        break;
//                    }
//                    if (needWake && p.isAsynchronous()) {
//                        needWake = false;
//                    }
//                }
//                msg.next = p; // invariant: p == prev.next
//                prev.next = msg;
//            }
//
//            // We can assume mPtr != 0 because mQuitting is false.
//            if (needWake) {
//                nativeWake(mPtr);
//            }
//        }
//        return true;
//    }


//    MessageQueue读取操作；该操作伴随着删除操作；如果消息队列中没有消息，那么next方法会一直阻塞在这里，当有新消息到来时，next方法会返回这条消息并将其从单链表中删除

//    Message next() {
//        // Return here if the message loop has already quit and been disposed.
//        // This can happen if the application tries to restart a looper after quit
//        // which is not supported.
//        final long ptr = mPtr;
//        if (ptr == 0) {
//            return null;
//        }
//
//        int pendingIdleHandlerCount = -1; // -1 only during first iteration
//        int nextPollTimeoutMillis = 0;
//        for (;;) {
//            if (nextPollTimeoutMillis != 0) {
//                Binder.flushPendingCommands();
//            }
//
//            nativePollOnce(ptr, nextPollTimeoutMillis);
//
//            synchronized (this) {
//                // Try to retrieve the next message.  Return if found.
//                final long now = SystemClock.uptimeMillis();
//                Message prevMsg = null;
//                Message msg = mMessages;
//                if (msg != null && msg.target == null) {
//                    // Stalled by a barrier.  Find the next asynchronous message in the queue.
//                    do {
//                        prevMsg = msg;
//                        msg = msg.next;
//                    } while (msg != null && !msg.isAsynchronous());
//                }
//                if (msg != null) {
//                    if (now < msg.when) {
//                        // Next message is not ready.  Set a timeout to wake up when it is ready.
//                        nextPollTimeoutMillis = (int) Math.min(msg.when - now, Integer.MAX_VALUE);
//                    } else {
//                        // Got a message.
//                        mBlocked = false;
//                        if (prevMsg != null) {
//                            prevMsg.next = msg.next;
//                        } else {
//                            mMessages = msg.next;
//                        }
//                        msg.next = null;
//                        if (DEBUG) Log.v(TAG, "Returning message: " + msg);
//                        msg.markInUse();
//                        return msg;
//                    }
//                } else {
//                    // No more messages.
//                    nextPollTimeoutMillis = -1;
//                }
//
//                // Process the quit message now that all pending messages have been handled.
//                if (mQuitting) {
//                    dispose();
//                    return null;
//                }
//
//                // If first time idle, then get the number of idlers to run.
//                // Idle handles only run if the queue is empty or if the first message
//                // in the queue (possibly a barrier) is due to be handled in the future.
//                if (pendingIdleHandlerCount < 0
//                        && (mMessages == null || now < mMessages.when)) {
//                    pendingIdleHandlerCount = mIdleHandlers.size();
//                }
//                if (pendingIdleHandlerCount <= 0) {
//                    // No idle handlers to run.  Loop and wait some more.
//                    mBlocked = true;
//                    continue;
//                }
//
//                if (mPendingIdleHandlers == null) {
//                    mPendingIdleHandlers = new MessageQueue.IdleHandler[Math.max(pendingIdleHandlerCount, 4)];
//                }
//                mPendingIdleHandlers = mIdleHandlers.toArray(mPendingIdleHandlers);
//            }
//
//            // Run the idle handlers.
//            // We only ever reach this code block during the first iteration.
//            for (int i = 0; i < pendingIdleHandlerCount; i++) {
//                final MessageQueue.IdleHandler idler = mPendingIdleHandlers[i];
//                mPendingIdleHandlers[i] = null; // release the reference to the handler
//
//                boolean keep = false;
//                try {
//                    keep = idler.queueIdle();
//                } catch (Throwable t) {
//                    Log.wtf(TAG, "IdleHandler threw exception", t);
//                }
//
//                if (!keep) {
//                    synchronized (this) {
//                        mIdleHandlers.remove(idler);
//                    }
//                }
//            }
//
//            // Reset the idle handler count to 0 so we do not run them again.
//            pendingIdleHandlerCount = 0;
//
//            // While calling an idle handler, a new message could have been delivered
//            // so go back and look again for a pending message without waiting.
//            nextPollTimeoutMillis = 0;
//        }
//    }
}
