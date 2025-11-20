class Config24 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9      : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac && sw.tool.xcode.15_2',
                        temurin     : 'xcode15.0.1'
                ],
                additionalTestLabels: [
                        openj9      : '',
                        temurin     : '!sw.os.osx.10_14'
                ],
                test                : 'default',
                configureArgs       : [
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        temurin     : '--enable-dtrace'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerFile: [
                        openj9      : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'sanity.external',
                                'dev.openjdk',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9      : 'hw.arch.x86 && sw.os.linux'
                ],
                additionalTestLabels: [
                        openj9      : '!(sw.os.cent.6||sw.os.rhel.6)',
                        temurin     : '!(centos6||rhel6)'
                ],
                configureArgs       : [
                        'openj9'    : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                        ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9      : 'hw.arch.x86 && sw.os.windows',
                        temurin     : 'win2022&&vs2022'
                ],
                cleanWorkspaceAfterBuild: true,
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [     
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system'
                        ]
            ],
                configureArgs       : [
                        openj9      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-jdk-rc-name="IBM Semeru Runtime"',
                        temurin     : "--with-ucrt-dll-dir='C:/progra~2/wi3cf2~1/10/Redist/10.0.22621.0/ucrt/DLLs/x64'"
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        temurin: 'openxl17&&aix720',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_2 && sw.tool.c++runtime.16_1'
                ],
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                additionalTestLabels: [
                        temurin      : 'sw.os.aix.7_2TL5'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        openj9      : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'sanity.external',
                                'dev.openjdk',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'ci.project.openj9 && hw.arch.s390x'
                ],
                dockerImage: 'runtimes/semeru/s390_rhel7_build_image',
                dockerRegistry: 'https://icr.io/',
                dockerCredential : 'ea4b3e98-4334-48d4-8211-98deb8767b55',
                dockerNode : 'sw.tool.docker',
                configureArgs       : [
                        openj9      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'sanity.external',
                                'dev.openjdk',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9      : 'ci.project.openj9 && hw.arch.ppc64le && sw.os.linux'
                ],
                configureArgs       : [
                        'openj9'    : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerNode          : 'sw.tool.docker',
                additionalNodeLabels: [
                        openj9      : 'hw.arch.aarch64 && sw.os.linux'
                ],
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'sanity.external',
                                'dev.openjdk'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system'
                        ]
                ],
                configureArgs : [
                        'openj9'    : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                        ],
                cleanWorkspaceAfterBuild: true,
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        aarch64Mac: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9      : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.mac && sw.tool.xcode.15_2',
                        temurin     : 'xcode15.0.1'
                ],
                cleanWorkspaceAfterBuild: true,
                test                : 'default',
                configureArgs       : [
                        openj9      : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        riscv64Linux      :  [
                os                  : 'linux',
                arch                : 'riscv64',
                crossCompile        : 'qemustatic',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:ubuntu2004_linux-riscv64',
                dockerArgs          : '--platform linux/riscv64',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes --enable-dtrace',
                buildArgs           : [
                        ]
        ]
  ]

}

Config24 config = new Config24()
return config.buildConfigurations
