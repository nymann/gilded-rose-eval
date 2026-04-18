default:
    @just --list

unit-test:
    mvn -q test

complexity:
    @echo "complexity: no checker wired yet"

lint:
    mvn -q compile
