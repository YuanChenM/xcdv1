export BatchId="BWQ201702"
java -jar -Xms256m -Xmx1024m -XX:PermSize=256m -XX:MaxPermSize=1024m $(dirname $0)/lib/msk-batch-1.0.jar $BatchId