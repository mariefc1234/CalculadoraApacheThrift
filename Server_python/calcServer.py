import sys
sys.path.append("gen-py")
from Calculadora import Calculadora

from thrift.transport import TSocket	# Endpoint -> conectar clientes
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol # Serialización
from thrift.server import TServer

class calcHandler:
	def multiplicar(self, numeroA, numeroB):  # Métodos del servidor
		print("Multiplicacion")
		return numeroA * numeroB
	def sumar(self,numeroA, numeroB):
		print("Adicion")
		return numeroA + numeroB
	def dividir(self,numeroA, numeroB):
		print("Division")
		return numeroA / numeroB
	def restar(self,numeroA, numeroB):
		print("Resta")
		return numeroA - numeroB


manejador = calcHandler()
procesador = Calculadora.Processor(manejador)

puerto = 9090
transporte_serv = TSocket.TServerSocket(port=puerto)
transporte_fact = TTransport.TBufferedTransportFactory()
protocolo_fact = TBinaryProtocol.TBinaryProtocolFactory()

servidor = TServer.TSimpleServer(procesador, transporte_serv, transporte_fact, protocolo_fact)
print("Iniciando el servidor en el puerto %s" % puerto)
servidor.serve()