package br.com.allumax.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

  @GetMapping("/all")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok("All permissions");
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@RequestParam Long id) {
    return ResponseEntity.ok("Permission by id");
  }

}
