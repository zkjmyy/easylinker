# -*- coding: utf-8 -*-  
import paho.mqtt.client as mqtt
import threading
import time

class EasyLinkerApp(threading.Thread):
    def __init__(self, *args, **kwargs):
        threading.Thread.__init__(self)
        self.deviceid="deviceid"
        self.type="type"
        self.port=1883
        self.client=mqtt.Client()

    def on_connect(self,client, userdata, flags, rc):
        print("info:"+self.type+"/"+self.deviceid)
        self.client.subscribe(self.type+"/"+self.deviceid)
        print("Connnect success!")
    

    def initial(self,url,port,deviceid,type,on_message):
                self.type=type
                self.deviceid=deviceid
                self.client.on_connect = self.on_connect
                self.client.on_message = on_message
                self.client.connect(url, port, 60)

    def run(self):
        try:
            self.client.loop_forever()
        except KeyboardInterrupt:
            exit()
            print("KeyboardInterrupt" )

    def stop(self):
        self.client.stop()

    def send_message(self,message):
        self.client.publish(self.type+"/"+self.deviceid, message)
        
    def info(self):
        print("EasyLinkerV1.0.0-debug")


def on_message(client, userdata, msg):
    print(msg.topic + " " + str(msg.qos) + " " + str(msg.payload))


app=EasyLinkerApp()
app.initial("192.168.199.197",1883,"69b067b1-9cf4-416a-bce4-7ab3f881273b","TYPE_VALUE",on_message)
app.start()



        

