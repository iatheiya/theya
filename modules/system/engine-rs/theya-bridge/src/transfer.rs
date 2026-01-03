use anyhow::Result;
use std::path::Path;

pub fn copy_file(src: &Path, dest: &Path) -> Result<u64> {
    let bytes = std::fs::copy(src, dest)?;
    Ok(bytes)
}
