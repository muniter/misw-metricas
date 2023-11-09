# Tenemos un archivo de logs que contiene errores, warnings y mensajes de información.
# Cada linea del archivo comienza con una letra que indica el tipo de log. Si
# comienza con 'E' es un error, si comienza con 'W' es un warning y si comienza
# con 'I' es de información. Luego de la letra, se encuentra un entero que
# indica el tiempo del log, y luego el mensaje del log. Excepto en el caso de
# los errores, que luego del tipo se encuentra un entero que indica la severidad
# del error. Por ejemplo:

# I 147 iniciando el programa
# W 604 this is not a warning
# E 2 4562 unexpected token


# Queremos separar los errores mas severos (con severidad mayor a 50) y ordenarlos
# cronologicamente. Despues, queremos imprimirlos a la pantalla.
def read_file_lines(file_path):
    with open(file_path, "r") as f:
        return [line.rstrip() for line in f.readlines()]


def extract_and_sort_errors(lines):
    errores = []
    for line in lines:
        if not line.startswith("E"):
            continue

        severidad = int(line.split(" ")[1])
        if severidad > 50:
            errores.append(line)

    errores.sort(key=lambda x: int(x.split(" ")[2]))
    return errores


def print_lines(errores):
    for error in errores:
        print(error)


def organize(file_path):
    lines = read_file_lines(file_path)
    errores = extract_and_sort_errors(lines)
    print_lines(errores)


def main():
    error_file_path = "./refactoring/problema2/data/error.log"
    organize(error_file_path)


if __name__ == "__main__":
    main()
