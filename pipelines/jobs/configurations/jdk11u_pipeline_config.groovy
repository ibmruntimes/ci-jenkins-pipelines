class Config11 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14',
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto',
                        "hotspot"     : '--enable-dtrace=auto'
                ]
        ],

        x64MacXL    : [
                os                   : 'mac',
                arch                 : 'x64',
                additionalNodeLabels: 'macos10.14',
                test                 : 'default',
                additionalFileNameTag: "macosXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto'
        ],

        x64MacIBM    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14',
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto  --with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.11.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.26.0-release"
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --enable-dtrace=auto',
                        "hotspot"     : '--enable-dtrace=auto',
                        "corretto"    : '--enable-dtrace=auto',
                        "SapMachine"  : '--enable-dtrace=auto',
                        "dragonwell"  : '--enable-dtrace=auto --enable-unlimited-crypto --with-jvm-variants=server --with-zlib=system --with-jvm-features=zgc'
                ]
        ],

        x64LinuxIBM  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --enable-dtrace=auto --with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.11.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.26.0-release"
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        hotspot:    'win2012',
                        openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                        dragonwell: 'win2012'
                ],
                buildArgs : [
                        hotspot : '--jvm-variant client,server'
                ],
                test                : 'default'
        ],

        x64WindowsIBM: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
                ],
                buildArgs : [
                        openj9 : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.26.0-release"
                ],
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--without-version-pre --without-version-opt --with-version-build=7 --with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.11.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"'
                ],
                additionalFileNameTag: "IBM"
        ],

        x64WindowsXL    : [
                os                   : 'windows',
                arch                 : 'x64',
                additionalNodeLabels : 'win2012&&vs2017',
                test                 : 'default',
                additionalFileNameTag: "windowsXL",
                configureArgs        : '--with-noncompressedrefs'
        ],

        x32Windows: [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels: 'win2012',
                buildArgs : [
                        hotspot : '--jvm-variant client,server'
                ],
                test                : 'default'
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        hotspot: 'xlc13&&aix710',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                : 'default',
                cleanWorkspaceAfterBuild: true
        ],

        ppc64AixIBM    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.11.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.26.0-release"
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : '--enable-dtrace=auto'
        ],

        s390xLinuxIBM    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : '--enable-dtrace=auto --with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.11.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"',
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.26.0-release"
        ],

        sparcv9Solaris    : [
                os                  : 'solaris',
                arch                : 'sparcv9',
                test                : false,
                configureArgs       : '--enable-dtrace=auto'
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                additionalNodeLabels : 'centos7',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        "hotspot"     : '--enable-dtrace=auto',
                        "openj9"      : '--enable-dtrace=auto --enable-jitserver'
                ]

        ],

        ppc64leLinuxIBM    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                additionalNodeLabels : 'centos7',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --enable-jitserver --with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.11.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.26.0-release"

        ],

        arm32Linux    : [
                os                  : 'linux',
                arch                : 'arm',
                test                : 'default',
                configureArgs       : '--enable-dtrace=auto'
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode         : 'sw.tool.docker',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                test                : 'default',
                configureArgs       : [
                        "hotspot" : '--enable-dtrace=auto',
                        "openj9" : '--enable-dtrace=auto',
                        "corretto" : '--enable-dtrace=auto',
                        "dragonwell" : "--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\""
                ]
        ],

        x64LinuxXL    : [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                arch                 : 'x64',
                test                 : "default",
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-jitserver --enable-dtrace=auto'
        ],
        s390xLinuxXL    : [
                os                   : 'linux',
                arch                 : 's390x',
                test                 : 'default',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto'
        ],
        ppc64leLinuxXL    : [
                os                   : 'linux',
                arch                 : 'ppc64le',
                additionalNodeLabels : 'centos7',
                test                 : 'default',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto --enable-jitserver'
        ],
        aarch64LinuxXL    : [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos7_build_image',
                arch                 : 'aarch64',
                test                 : 'default',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-dtrace=auto'
        ],
        riscv64Linux      :  [
                os                   : 'linux',
                arch                 : 'riscv64',
                dockerImage          : [
                        "openj9" : 'adoptopenjdk/centos6_build_image',
                ],
                dockerNode         : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                crossCompile         : [
                        "openj9"     : 'x64'
                ],
                buildArgs            : [
                        "openj9"     : '--cross-compile'
                ],
                configureArgs        : [
                        "openj9"     : '--disable-ddr --openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root'
                ],
                test                 : false
        ]
  ]

}

Config11 config = new Config11()
return config.buildConfigurations
