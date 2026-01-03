use std::collections::HashMap;

pub struct FileMap {
    mappings: HashMap<String, String>,
}

impl FileMap {
    pub fn new() -> Self {
        Self {
            mappings: HashMap::new(),
        }
    }
}
