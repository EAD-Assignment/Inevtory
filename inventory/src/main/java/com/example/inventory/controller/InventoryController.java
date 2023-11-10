//package com.example.inventory.controller;
//
//import com.example.inventory.model.InventoryItem;
//import com.example.inventory.service.InventoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//@RestController
//@RequestMapping("api/inventory")
//public class InventoryController {
//
//    @Autowired
//    private InventoryService inventoryService;
//    @GetMapping
//    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
//        try {
//            List<InventoryItem> items = inventoryService.getAllInventoryItems();
//            return new ResponseEntity<>(items, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{productId}")
//    public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable("productId") String id) {
//        Optional<InventoryItem> item = inventoryService.getInventoryItem(id);
//
//        return item.map(inventoryItem -> new ResponseEntity<>(inventoryItem, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping
//    public ResponseEntity<InventoryItem> createInventoryItem(@RequestBody InventoryItem item) {
//        try {
//            InventoryItem inventoryItem = inventoryService.createInventoryItem(item);
//            return new ResponseEntity<>(inventoryItem, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<InventoryItem> updateInventoryItem(@PathVariable("id") String id, @RequestBody InventoryItem itemToUpdate) {
//        InventoryItem savedItem = inventoryService.updateInventoryItem(id, itemToUpdate);
//
//        if (savedItem != null) {
//            return new ResponseEntity<>(savedItem, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteInventoryItem(@PathVariable("id") String id) {
//        try {
//            inventoryService.deleteInventoryItem(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
////    @PostMapping("/checkAvailability")
////    public ResponseEntity<String> checkProductAvailability(@RequestBody List<InventoryItem> productAvailabilityRequests) {
////        try {
////            // Implement logic to check product availability and update quantities
////            for (InventoryItem request : productAvailabilityRequests) {
////                String productId = String.valueOf(request.getId());
////                int requestedQuantity = request.getQuantity();
////
////                // Fetch the inventory item by productId
////                Optional<InventoryItem> item = inventoryService.getInventoryItem(productId);
////
////                if (item.isPresent()) {
////                    InventoryItem inventoryItem = item.get();
////                    int availableQuantity = inventoryItem.getQuantity();
////
////                    if (availableQuantity >= requestedQuantity) {
////                        // Sufficient quantity is available, deduct it
////                        inventoryItem.setQuantity(availableQuantity - requestedQuantity);
////                        inventoryService.updateInventoryItem(productId, inventoryItem);
////                    } else {
////                        // Not enough quantity available for this product
////                        return ResponseEntity.badRequest().body("Product with ID " + productId + " does not have enough quantity available.");
////                    }
////                } else {
////                    // Product not found in the inventory
////                    return ResponseEntity.badRequest().body("Product with ID " + productId + " does not exist in the inventory.");
////                }
////            }
////            return ResponseEntity.ok("Products are available, and quantities updated.");
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error checking product availability.");
////        }
////    }
//
//    @PostMapping("/checkAvailability")
//    public ResponseEntity<String> checkProductAvailability(@RequestBody List<InventoryItem> productAvailabilityRequests) {
//        try {
//            // Implement logic to check product availability and update quantities
//            for (InventoryItem request : productAvailabilityRequests) {
//                if (request.getProductId() == null) {
//                    // Handle the case where ID is null
//                    return ResponseEntity.badRequest().body("Product ID is missing.");
//                }
//
//                String productId = String.valueOf(request.getProductId());
//                int requestedQuantity = request.getQuantity();
//
//                // Fetch the inventory item by productId
//                Optional<InventoryItem> item = inventoryService.getInventoryItem(productId);
//
//                if (item.isPresent()) {
//                    InventoryItem inventoryItem = item.get();
//                    int availableQuantity = inventoryItem.getQuantity();
//
//                    if (availableQuantity >= requestedQuantity) {
//                        // Sufficient quantity is available, deduct it
//                        inventoryItem.setQuantity(availableQuantity - requestedQuantity);
//                        inventoryService.updateInventoryItem(productId, inventoryItem);
//                    } else {
//                        // Not enough quantity available for this product
//                        return ResponseEntity.badRequest().body("Product with ID " + productId + " does not have enough quantity available.");
//                    }
//                } else {
//                    // Product not found in the inventory
//                    return ResponseEntity.badRequest().body("Product with ID " + productId + " does not exist in the inventory.");
//                }
//            }
//            return ResponseEntity.ok("Products are available, and quantities updated.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error checking product availability.");
//        }
//    }
//
//
//
//}
//package com.example.inventory.controller;
//
//import com.example.inventory.model.InventoryItem;
//import com.example.inventory.service.InventoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/inventory")
//public class InventoryController {
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @GetMapping
//    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
//        try {
//            List<InventoryItem> items = inventoryService.getAllInventoryItems();
//            return new ResponseEntity<>(items, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{productId}")
//    public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable("productId") String id) {
//        Optional<InventoryItem> item = inventoryService.getInventoryItem(id);
//
//        return item.map(inventoryItem -> new ResponseEntity<>(inventoryItem, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping
//    public ResponseEntity<InventoryItem> createInventoryItem(@RequestBody InventoryItem item) {
//        try {
//            InventoryItem inventoryItem = inventoryService.createInventoryItem(item);
//            return new ResponseEntity<>(inventoryItem, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<InventoryItem> updateInventoryItem(@PathVariable("id") String id, @RequestBody InventoryItem itemToUpdate) {
//        InventoryItem savedItem = inventoryService.updateInventoryItem(id, itemToUpdate);
//
//        if (savedItem != null) {
//            return new ResponseEntity<>(savedItem, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteInventoryItem(@PathVariable("id") String id) {
//        try {
//            inventoryService.deleteInventoryItem(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/checkAvailability")
//    public ResponseEntity<String> checkProductAvailability(@RequestBody List<InventoryItem> productAvailabilityRequests) {
//        try {
//            for (InventoryItem request : productAvailabilityRequests) {
//                if (request.getProductId() == null) {
//                    return ResponseEntity.badRequest().body("Product ID is missing.");
//                }
//
//                String productId = String.valueOf(request.getProductId());
//                int requestedQuantity = request.getQuantity();
//
//                Optional<InventoryItem> item = inventoryService.getInventoryItem(productId);
//
//                if (item.isPresent()) {
//                    InventoryItem inventoryItem = item.get();
//                    int availableQuantity = inventoryItem.getQuantity();
//
//                    if (availableQuantity >= requestedQuantity) {
//                        inventoryItem.setQuantity(availableQuantity - requestedQuantity);
//                        inventoryService.updateInventoryItem(productId, inventoryItem);
//                    } else {
//                        return ResponseEntity.badRequest().body("Product with ID " + productId + " does not have enough quantity available.");
//                    }
//                } else {
//                    return ResponseEntity.badRequest().body("Product with ID " + productId + " does not exist in the inventory.");
//                }
//            }
//            return ResponseEntity.ok("Products are available, and quantities updated.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error checking product availability.");
//        }
//    }
//}

//
//package com.example.inventory.controller;
//
//import com.example.inventory.model.InventoryItem;
//import com.example.inventory.service.InventoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/inventory")
//public class InventoryController {
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @GetMapping
//    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
//        try {
//            List<InventoryItem> items = inventoryService.getAllInventoryItems();
//            return new ResponseEntity<>(items, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{productId}")
//    public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable("productId") String id) {
//        Optional<InventoryItem> item = inventoryService.getInventoryItem(id);
//
//        return item.map(inventoryItem -> new ResponseEntity<>(inventoryItem, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping
//    public ResponseEntity<InventoryItem> createInventoryItem(@RequestBody InventoryItem item) {
//        try {
//            InventoryItem inventoryItem = inventoryService.createInventoryItem(item);
//            return new ResponseEntity<>(inventoryItem, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<InventoryItem> updateInventoryItem(@PathVariable("id") String id, @RequestBody InventoryItem itemToUpdate) {
//        InventoryItem savedItem = inventoryService.updateInventoryItem(id, itemToUpdate);
//
//        if (savedItem != null) {
//            return new ResponseEntity<>(savedItem, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteInventoryItem(@PathVariable("id") String id) {
//        try {
//            inventoryService.deleteInventoryItem(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/checkAvailability")
//    public ResponseEntity<String> checkProductAvailability(@RequestBody List<InventoryItem> productAvailabilityRequests) {
//        try {
//            for (InventoryItem request : productAvailabilityRequests) {
//                if (request.getProductId() == null) {
//                    return ResponseEntity.badRequest().body("Product ID is missing.");
//                }
//
//                String productId = String.valueOf(request.getProductId());
//                int requestedQuantity = request.getQuantity();
//
//                Optional<InventoryItem> item = inventoryService.getInventoryItem(productId);
//
//                if (item.isPresent()) {
//                    InventoryItem inventoryItem = item.get();
//                    int availableQuantity = inventoryItem.getQuantity();
//
//                    if (availableQuantity >= requestedQuantity) {
//                        inventoryItem.setQuantity(availableQuantity - requestedQuantity);
//                        inventoryService.updateInventoryItem(productId, inventoryItem);
//                    } else {
//                        return ResponseEntity.badRequest().body("Product with ID " + productId + " does not have enough quantity available.");
//                    }
//                } else {
//                    return ResponseEntity.badRequest().body("Product with ID " + productId + " does not exist in the inventory.");
//                }
//            }
//            return ResponseEntity.ok("Products are available, and quantities updated.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error checking product availability.");
//        }
//    }
//}

//
//package com.example.inventory.controller;
//
//import com.example.inventory.model.InventoryItem;
//import com.example.inventory.service.InventoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.ResponseEntity;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/inventory")
//public class InventoryController {
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @GetMapping
//    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
//        try {
//            List<InventoryItem> items = inventoryService.getAllInventoryItems();
//            return new ResponseEntity<>(items, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{productId}")
//    public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable("productId") String id) {
//        Optional<InventoryItem> item = inventoryService.getInventoryItem(id);
//
//        return item.map(inventoryItem -> new ResponseEntity<>(inventoryItem, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping
//    public ResponseEntity<InventoryItem> createInventoryItem(@RequestBody InventoryItem item) {
//        try {
//            InventoryItem inventoryItem = inventoryService.createInventoryItem(item);
//            return new ResponseEntity<>(inventoryItem, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<InventoryItem> updateInventoryItem(@PathVariable("id") String id, @RequestBody InventoryItem itemToUpdate) {
//        InventoryItem savedItem = inventoryService.updateInventoryItem(id, itemToUpdate);
//
//        if (savedItem != null) {
//            return new ResponseEntity<>(savedItem, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteInventoryItem(@PathVariable("id") String id) {
//        try {
//            inventoryService.deleteInventoryItem(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/checkAvailability")
//    public ResponseEntity<String> checkProductAvailability(@RequestBody List<InventoryItem> productAvailabilityRequests) {
//        try {
//            for (InventoryItem request : productAvailabilityRequests) {
//                if (request.getProductId() == null) {
//                    return new ResponseEntity<>("Invalid order status", HttpStatus.BAD_REQUEST);
//                   // return ResponseEntity.badRequest().body("Product ID is missing.");
//                }
//
//                String productId = String.valueOf(request.getProductId());
//                int requestedQuantity = request.getQuantity();
//
//                Optional<InventoryItem> item = inventoryService.getInventoryItem(productId);
//
//                if (item.isPresent()) {
//                    InventoryItem inventoryItem = item.get();
//                    int availableQuantity = inventoryItem.getQuantity();
//
//                    if (availableQuantity >= requestedQuantity) {
//                        inventoryItem.setQuantity(availableQuantity - requestedQuantity);
//                        inventoryService.updateInventoryItem(productId, inventoryItem);
//                    } else {
//                       return ResponseEntity.badRequest().body("Product with ID " + productId + " does not have enough quantity available.");
//                    }
//                } else {
//                    return ResponseEntity.badRequest().body("Product with ID " + productId + " does not exist in the inventory.");
//                }
//            }
//            return ResponseEntity.ok("Products are available, and quantities updated.");
//        } catch (Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error checking product availability.");
//        }
//    }
//}

//
//package com.example.inventory.controller;
//
//import com.example.inventory.model.InventoryItem;
//import com.example.inventory.service.InventoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.ResponseEntity;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/inventory")
//public class InventoryController {
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @GetMapping
//    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
//        try {
//            List<InventoryItem> items = inventoryService.getAllInventoryItems();
//            return new ResponseEntity<>(items, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{productId}")
//    public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable("productId") String id) {
//        Optional<InventoryItem> item = inventoryService.getInventoryItem(id);
//
//        return item.map(inventoryItem -> new ResponseEntity<>(inventoryItem, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping
//    public ResponseEntity<InventoryItem> createInventoryItem(@RequestBody InventoryItem item) {
//        try {
//            InventoryItem inventoryItem = inventoryService.createInventoryItem(item);
//            return new ResponseEntity<>(inventoryItem, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<InventoryItem> updateInventoryItem(@PathVariable("id") String id, @RequestBody InventoryItem itemToUpdate) {
//        InventoryItem savedItem = inventoryService.updateInventoryItem(id, itemToUpdate);
//
//        if (savedItem != null) {
//            return new ResponseEntity<>(savedItem, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteInventoryItem(@PathVariable("id") String id) {
//        try {
//            inventoryService.deleteInventoryItem(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/checkAvailability")
//    public ResponseEntity<String> checkProductAvailability(@RequestBody List<InventoryItem> productAvailabilityRequests) {
//        try {
//            for (InventoryItem request : productAvailabilityRequests) {
//                if (request.getProductId() == null) {
//                    return new ResponseEntity<>("Product ID is missing.", HttpStatus.BAD_REQUEST);
//                }
//
//                String productId = String.valueOf(request.getProductId());
//                int requestedQuantity = request.getQuantity();
//
//                Optional<InventoryItem> item = inventoryService.getInventoryItem(productId);
//
//                if (item.isPresent()) {
//                    InventoryItem inventoryItem = item.get();
//                    int availableQuantity = inventoryItem.getQuantity();
//
//                    if (availableQuantity >= requestedQuantity) {
//                        inventoryItem.setQuantity(availableQuantity - requestedQuantity);
//                        inventoryService.updateInventoryItem(productId, inventoryItem);
//                    } else {
//                        return new ResponseEntity<>("Product with ID " + productId + " does not have enough quantity available.", HttpStatus.BAD_REQUEST);
//                    }
//                } else {
//                    return new ResponseEntity<>("Product with ID " + productId + " does not exist in the inventory.", HttpStatus.BAD_REQUEST);
//                }
//            }
//            return new ResponseEntity<>("Products are available, and quantities updated.", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error checking product availability.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}


//
//package com.example.inventory.controller;
//import com.example.inventory.model.InventoryItem;
//import com.example.inventory.service.InventoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
////
////@RestController
////@RequestMapping("api/inventory")
////public class InventoryController {
////
////    @Autowired
////    private InventoryService inventoryService;
////
////    @GetMapping
////    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
////        try {
////            List<InventoryItem> items = inventoryService.getAllInventoryItems();
////            return new ResponseEntity<>(items, HttpStatus.OK);
////        } catch (Exception e) {
////            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////    }
////
////    @GetMapping("/{productId}")
////    public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable("productId") String id) {
////        Optional<InventoryItem> item = inventoryService.getInventoryItem(id);
////
////        return item.map(inventoryItem -> new ResponseEntity<>(inventoryItem, HttpStatus.OK))
////                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
////    }
////
////    @PostMapping
////    public ResponseEntity<InventoryItem> createInventoryItem(@RequestBody InventoryItem item) {
////        try {
////            InventoryItem inventoryItem = inventoryService.createInventoryItem(item);
////            return new ResponseEntity<>(inventoryItem, HttpStatus.CREATED);
////        } catch (Exception e) {
////            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////    }
////
////    @PutMapping("/{id}")
////    public ResponseEntity<InventoryItem> updateInventoryItem(@PathVariable("id") String id, @RequestBody InventoryItem itemToUpdate) {
////        try {
////            InventoryItem savedItem = inventoryService.updateInventoryItem(id, itemToUpdate);
////            if (savedItem != null) {
////                return new ResponseEntity<>(savedItem, HttpStatus.OK);
////            } else {
////                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////            }
////        } catch (Exception e) {
////            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////    }
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<HttpStatus> deleteInventoryItem(@PathVariable("id") String id) {
////        try {
////            inventoryService.deleteInventoryItem(id);
////            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////        } catch (Exception e) {
////            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////    }
////
////    @PostMapping("/checkAvailability")
////    public ResponseEntity<String> checkProductAvailability(@RequestBody List<InventoryItem> productAvailabilityRequests) {
////        try {
////            for (InventoryItem request : productAvailabilityRequests) {
////                if (request.getProductId() == null) {
////                    return new ResponseEntity<>("Product ID is missing.", HttpStatus.BAD_REQUEST);
////                }
////
////                String productId = String.valueOf(request.getProductId());
////                int requestedQuantity = request.getQuantity();
////
////                Optional<InventoryItem> item = inventoryService.getInventoryItem(productId);
////
////                if (item.isPresent()) {
////                    InventoryItem inventoryItem = item.get();
////                    int availableQuantity = inventoryItem.getQuantity();
////
////                    if (availableQuantity >= requestedQuantity) {
////                        inventoryItem.setQuantity(availableQuantity - requestedQuantity);
////                        inventoryService.updateInventoryItem(productId, inventoryItem);
////                    } else {
////                        return new ResponseEntity<>("Product with ID " + productId + " does not have enough quantity available.", HttpStatus.BAD_REQUEST);
////                    }
////                } else {
////                    return new ResponseEntity<>("Product with ID " + productId + " does not exist in the inventory.", HttpStatus.BAD_REQUEST);
////                }
////            }
////            return new ResponseEntity<>("Products are available, and quantities updated.", HttpStatus.OK);
////        } catch (Exception e) {
////            return new ResponseEntity<>("Error checking product availability.", HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////    }
////}
//@RestController
//@RequestMapping("api/inventory")
//public class InventoryController {
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @GetMapping("/getall")
//    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
//        try {
//            List<InventoryItem> items = inventoryService.getAllInventoryItems();
//            return new ResponseEntity<>(items, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/get/{Id}")
//    public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable("productId") String id) {
//        Optional<InventoryItem> item = inventoryService.getInventoryItem(id);
//
//        return item.map(inventoryItem -> new ResponseEntity<>(inventoryItem, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<String> createInventoryItem(@RequestBody InventoryItem item) {
//        try {
//            InventoryItem inventoryItem = inventoryService.createInventoryItem(item);
//            return new ResponseEntity<>("Product added successfully.", HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to add the product.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> updateInventoryItem(@PathVariable("id") String id, @RequestBody InventoryItem itemToUpdate) {
//        try {
//            InventoryItem savedItem = inventoryService.updateInventoryItem(id, itemToUpdate);
//            if (savedItem != null) {
//                return new ResponseEntity<>("Product updated successfully.", HttpStatus.OK);
//            } else {
//                return new ResponseEntity("Product with ID " + id + " not found.", HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to update the product.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteInventoryItem(@PathVariable("id") String id) {
//        try {
//            inventoryService.deleteInventoryItem(id);
//            return new ResponseEntity<>("Product with ID " + id + " deleted successfully.", HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to delete the product.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/checkAvailability")
//    public ResponseEntity<String> checkProductAvailability(@RequestBody List<InventoryItem> productAvailabilityRequests) {
//        try {
//            for (InventoryItem request : productAvailabilityRequests) {
//                if (request.getProductId() == null) {
//                    return new ResponseEntity<>("Product ID is missing.", HttpStatus.BAD_REQUEST);
//                }
//
//                String productId = String.valueOf(request.getProductId());
//                int requestedQuantity = request.getQuantity();
//
//                Optional<InventoryItem> item = inventoryService.getInventoryItem(productId);
//
//                if (item.isPresent()) {
//                    InventoryItem inventoryItem = item.get();
//                    int availableQuantity = inventoryItem.getQuantity();
//
//                    if (availableQuantity >= requestedQuantity) {
//                        inventoryItem.setQuantity(availableQuantity - requestedQuantity);
//                        inventoryService.updateInventoryItem(productId, inventoryItem);
//                    } else {
//                        return new ResponseEntity<>("Product with ID " + productId + " does not have enough quantity available.", HttpStatus.BAD_REQUEST);
//                    }
//                } else {
//                    return new ResponseEntity<>("Product with ID " + productId + " does not exist in the inventory.", HttpStatus.BAD_REQUEST);
//                }
//            }
//            return new ResponseEntity<>("Products are available, and quantities updated.", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error checking product availability.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}



package com.example.inventory.controller;
import com.example.inventory.model.InventoryItem;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
        try {
            List<InventoryItem> items = inventoryService.getAllInventoryItems();
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable("id") String id) {
        Optional<InventoryItem> item = inventoryService.getInventoryItem(id);

        return item.map(inventoryItem -> new ResponseEntity<>(inventoryItem, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createInventoryItem(@RequestBody InventoryItem item) {
        try {
            InventoryItem inventoryItem = inventoryService.createInventoryItem(item);
            return new ResponseEntity<>("Product added successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add the product.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateInventoryItem(@PathVariable("id") String id, @RequestBody InventoryItem itemToUpdate) {
        try {
            InventoryItem savedItem = inventoryService.updateInventoryItem(id, itemToUpdate);
            if (savedItem != null) {
                return new ResponseEntity<>("Product updated successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity("Product with ID " + id + " not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update the product.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInventoryItem(@PathVariable("id") String id) {
        try {
            inventoryService.deleteInventoryItem(id);
            return new ResponseEntity<>("Product with ID " + id + " deleted successfully.", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete the product.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/checkAvailability")
    public ResponseEntity<String> checkProductAvailability(@RequestBody List<InventoryItem> productAvailabilityRequests) {
        try {
            for (InventoryItem request : productAvailabilityRequests) {
                if (request.getProductId() == null) {
                    return new ResponseEntity<>("Product ID is missing.", HttpStatus.BAD_REQUEST);
                }

                String productId = String.valueOf(request.getProductId());
                int requestedQuantity = request.getQuantity();

                Optional<InventoryItem> item = inventoryService.getInventoryItem(productId);

                if (item.isPresent()) {
                    InventoryItem inventoryItem = item.get();
                    int availableQuantity = inventoryItem.getQuantity();

                    if (availableQuantity >= requestedQuantity) {
                        inventoryItem.setQuantity(availableQuantity - requestedQuantity);
                        inventoryService.updateInventoryItem(productId, inventoryItem);
                    } else {
                        return new ResponseEntity<>("Product with ID " + productId + " does not have enough quantity available.", HttpStatus.BAD_REQUEST);
                    }
                } else {
                    return new ResponseEntity<>("Product with ID " + productId + " does not exist in the inventory.", HttpStatus.BAD_REQUEST);
                }
            }
            return new ResponseEntity<>("Products are available, and quantities updated.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error checking product availability.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
