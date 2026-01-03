use std::path::{Path, PathBuf};
use anyhow::Result;

pub struct Sandbox {
    root_path: PathBuf,
}

impl Sandbox {
    pub fn new(root: PathBuf) -> Self {
        Self { root_path: root }
    }

    pub fn resolve(&self, path: &str) -> Result<PathBuf> {
        let joined = self.root_path.join(path);
        Ok(joined)
    }
}
