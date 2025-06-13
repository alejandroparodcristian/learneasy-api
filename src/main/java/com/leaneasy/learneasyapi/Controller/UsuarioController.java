package com.leaneasy.learneasyapi.Controller;

import com.leaneasy.learneasyapi.DTO.LoginRequest;
import com.leaneasy.learneasyapi.DTO.UsuarioDTO;
import com.leaneasy.learneasyapi.Model.Usuario;
import com.leaneasy.learneasyapi.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService servicio;

    public UsuarioController(UsuarioService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Usuario> listar() {
        return servicio.listarTodos();
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario usuario) {
        if (servicio.correoExiste(usuario.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Correo ya registrado");
        }
        Usuario guardado = servicio.guardar(usuario);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Integer id) {
        return servicio.buscarPorId(id);
    }

    @PutMapping("/{id}/nombre")
    public ResponseEntity<UsuarioDTO> actualizarNombre(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        String nuevoNombre = body.get("nombre");
        Usuario usuario = servicio.actualizarNombre(id, nuevoNombre);

        UsuarioDTO dto = new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getFechaRegistro()
        );

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioDTO>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(servicio.buscarPorNombre(nombre));
    }



    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicio.eliminarPorId(id);
    }
    //Login usuario
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Usuario usuario = servicio.login(request.getEmail(), request.getPassword());
        if (usuario != null) {
            UsuarioDTO dto = new UsuarioDTO(
                    usuario.getId(),
                    usuario.getNombre(),
                    usuario.getEmail(),
                    usuario.getFechaRegistro()
            );
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    @PutMapping("/{id}/foto")
    public ResponseEntity<?> actualizarFoto(@PathVariable Integer id, @RequestBody String fotoUrl) {
        Usuario usuario = servicio.buscarPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        usuario.setFotoUrl(fotoUrl.replace("\"", "")); // elimina comillas si vienen en el JSON
        servicio.guardar(usuario);

        return ResponseEntity.ok("Foto actualizada");
    }


}
