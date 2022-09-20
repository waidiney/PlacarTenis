# criando imagem
docker build -t api-placar-tenis:0.1 .
# criando container
docker-compose -up -d --build
