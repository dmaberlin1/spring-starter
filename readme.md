docker run --name some-postgres -e POSTGRES_PASSWORD=pass -p 5433:5432 -d postgres:14.1

docker start some-postgres

docker run --rm --name some-postgres -e POSTGRES_PASSWORD=pass -p 5433:5432 -d postgres:14.1

docker rm some-postgres