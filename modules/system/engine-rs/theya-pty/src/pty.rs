use anyhow::Result;
use std::os::unix::io::RawFd;

pub struct PtyPair {
    pub master: RawFd,
    pub slave: RawFd,
}

impl PtyPair {
    pub fn open() -> Result<Self> {
        Ok(Self {
            master: 0,
            slave: 0,
        })
    }
}
