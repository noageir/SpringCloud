启动：consul agent -dev -ui -bootstrap-expect=1 -data-dir=/tmp/consul -node=agent-one -bind=192.168.1.80 -datacenter=consul -client=192.168.1.80


关闭：consul leave -http-addr=192.168.1.80:8500

consul catalog nodes -http-addr=192.168.1.80:8500

