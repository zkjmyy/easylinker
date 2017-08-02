import time
import sys
import stomp

class MyListener(object):
    def on_error(self, headers, message):
        print('received an error %s' % message)
    def on_message(self, headers, message):
        print('received a message %s' % message)

#官方示例的连接代码也落后了，现在分协议版本192.168.199.197:61616
conn = stomp.Connection10([('192.168.199.197',61613)])
conn.set_listener('', MyListener())
conn.start()
conn.connect()

conn.subscribe(destination='/TYPE_MEDIA', id=1, ack='auto')
#注意，官方示例这样发送消息是有问题的
#conn.send(body='hello,garfield! this is '.join(sys.argv[1:]), destination='/TYPE_MEDIA')
conn.send(body='hello,garfield!', destination='/TYPE_MEDIA')

time.sleep(2)
#conn.disconnect()
