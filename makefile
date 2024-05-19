fichJar = distancia.jar

limpiar:
	rm -f $(fichJar)
	rm -rf bin

compilar: limpiar
	mkdir -p bin
	find . -name "*.java" | xargs javac -cp bin -d bin

jar: compilar
	jar cvfm $(fichJar) Manifest.txt -C bin .