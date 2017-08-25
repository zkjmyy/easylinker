# -*- coding: utf-8 -*-  
import paho.mqtt.client as mqtt
import threading
import time
import urllib.request
import urllib.parse

class EasyLinkerApp(threading.Thread):
    def __init__(self, *args, **kwargs):
        threading.Thread.__init__(self)
        self.deviceid="deviceid"
        self.type="type"
        self.port=1883
        self.url="url"
        self.client=mqtt.Client()
        self.weburl="weburl"

    def on_connect(self,client, userdata, flags, rc):
        print("info:"+self.type+"/"+self.deviceid)
        self.client.subscribe(self.type+"/"+self.deviceid)
        self.online(self.weburl)
        print("Connnect success!")

    #@staticmethod
    def online(self,weburl):
        url = "http://"+self.weburl+"/device/state?deviceId="+self.deviceid+"&state=ONLINE"
        with urllib.request.urlopen(url) as f:
                print(f.read().decode('utf-8'))
    
        #@staticmethod
    def offline(self,weburl):
        url = "http://"+self.weburl+"/device/state?deviceId="+self.deviceid+"&state=OFFLINE"
        with urllib.request.urlopen(url) as f:
                print(f.read().decode('utf-8'))
    

    def initial(self,url,port,deviceid,type,on_message,weburl):
                self.weburl=weburl
                self.url=url
                self.port=port
                self.type=type
                self.deviceid=deviceid
                self.client.on_connect = self.on_connect
                self.client.on_message = on_message
                self.client.connect(self.url, self.port, 60)

    def run(self):
        try:
            self.client.loop_forever()
        except KeyboardInterrupt:
            self.offline()
            exit()

    def stop(self):
        self.client.stop()

    def send_message(self,message):
        self.client.publish(self.type+"/"+self.deviceid, message)
        

def on_message(client, userdata, msg):
    print(msg.topic + " " + str(msg.qos) + " " + str(msg.payload))


app=EasyLinkerApp()
app.initial("192.168.199.197",1883,"69b067b1-9cf4-416a-bce4-7ab3f881273b","TYPE_VALUE",on_message,"localhost:6666")
app.start()



        

