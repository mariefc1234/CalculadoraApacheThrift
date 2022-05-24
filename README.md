##Instrucciones para su ejecución

##Servidor
Entrar a la carpeta servidorNode
Ejecutar: 
Thrift -r --gen js:node ./calc.thrift
npm install
node app.js

##Cliente
Entrar a la carpeta de Cliente
Ejecutar: 
    Thrift -r --gen py ./calc.thrift
    pip3 install Thrift
    python ./CalcClient.py
