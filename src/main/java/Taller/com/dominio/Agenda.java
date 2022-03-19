package Taller.com.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Agenda {
    private List<Contacto> contactos;

    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    public void agregar(String nombre, String apellido, long celular) {
        Contacto contactoAAgregar = new Contacto(nombre, apellido, celular);
        if ((this.contactos.size()+1)<=50) {
            this.contactos.add(contactoAAgregar);
        } else {
            System.out.println("No es posible agregar, la agenda esta llena ------------");
        }
    }

    public void eliminar(long celular) {
        Contacto contactoAEliminar = this.buscarPorCelularConFilter(celular);
        if (contactoAEliminar != null) {
            this.contactos.remove(contactoAEliminar);
            System.out.println("Se eliminó el contacto correctamente " + contactoAEliminar.getNombre());
        } else {
            System.out.println("¡ERROR! No se puede eliminar Porque el contacto " + contactoAEliminar.getNombre() + " no existe.");
        }
    }

    public Contacto buscarPorCelularConFilter(long celular) {
        Contacto contactoRequerido = this.contactos.stream()
                .filter(contacto -> contacto.getCelular() == celular)
                .findFirst().orElse(null);
        if (contactoRequerido != null){
            System.out.println("Contacto buscado: " + contactoRequerido.getNombre() + " " + contactoRequerido.getApellido());
            return contactoRequerido;
        }
        else {
            System.out.println("El contacto no se encuentra ");
            return null;
        }
    }

    public void buscarPorApellido(String apellido) {
        List<Contacto> contactoABuscar = this.contactos.stream()
                .filter(apell -> apell.getApellido().equalsIgnoreCase(apellido))
                .collect(Collectors.toList());
        if((contactoABuscar != null)&&(contactoABuscar.size()>0)){
            System.out.println("Contactos encontrados por apellido: ");
            contactoABuscar.forEach(contacto -> System.out.println(contacto.getApellido() + " "
                    + contacto.getNombre() + " " + contacto.getCelular()));
        }
        else{
            System.out.println("No se encuentran contactos con las caracteristicas mencionadas.");
        }
    }

    public List<Contacto> buscarPorNombre(String nombre) {
        List<Contacto> contactPorNomb = this.contactos.stream()
                .filter(name -> name.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
        if ((contactPorNomb != null)&&(contactPorNomb.size()>0)) {
            System.out.println("Contactos encontrados por nombre: ");
            contactPorNomb.forEach(contact -> System.out.println(contact.getNombre() + " "
                    + contact.getApellido() + " --- " + contact.getCelular()));
            return contactPorNomb;
        } else {
            System.out.println("No se encuentran contactos con las caracteristicas mencionadas.");
            return null;
        }
    }

    public void editar(long celularAntiguo, long celularNuevo) {
        Contacto c = buscarPorCelularConFilter(celularAntiguo);
        if(c != null) {
            int posicionAReemplazar = this.contactos.indexOf(c);
            c.setCelular(celularNuevo);
            this.contactos.set(posicionAReemplazar, c);
            System.out.println("Se ha editado el contacto: "+celularAntiguo+" por: "+celularNuevo);
        } else {
            System.out.println("El contacto a editar no existe.");
        }
    }

    public void ordenarAlfabeticamente() {
        this.contactos.sort(Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido));
        this.imprimirAgenda();
    }

    public Contacto buscarConForEach(long celular) {
        AtomicReference<Contacto> contactoBuscado = new AtomicReference<>();
        this.contactos.forEach(contacto -> {
            if (contacto.getCelular() == celular) {
                contactoBuscado.set(contacto);
            }
        });
        return contactoBuscado.get();
    }

    private void imprimirAgenda() {
        this.contactos.forEach(c -> System.out.println(c.getNombre() + " "
                + c.getApellido() + " -- " + c.getCelular()));
    }

    public List<Contacto> getContactos() {
        return contactos;
    }
}
